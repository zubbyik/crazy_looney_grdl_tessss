FROM adoptopenjdk:11-jdk-hotspot

CMD ["gradle"]

ENV GRADLE_HOME /opt/gradle

RUN set -o errexit -o nounset \
    && echo "Adding gradle user and group" \
    && groupadd --system --gid 1000 gradle \
    && useradd --system --gid gradle --uid 1000 --shell /bin/bash --create-home gradle \
    && mkdir /home/gradle/.gradle \
    && chown --recursive gradle:gradle /home/gradle \
    \
    && echo "Symlinking root Gradle cache to gradle Gradle cache" \
    && ln -s /home/gradle/.gradle /root/.gradle

VOLUME /home/gradle/.gradle

WORKDIR /home/gradle

RUN apt-get update \
    && apt-get install --yes --no-install-recommends \
        fontconfig \
        unzip \
        wget \
        bzr \
        git \
        git-lfs \
        mercurial \
        openssh-client \
        subversion \
        openjdk-11-jdk \
        curl  \
    && rm -rf /var/lib/apt/lists/*

ENV PLAYWRIGHT_BROWSERS_PATH=${PWD}/ms-playwright
RUN mkdir ms-playwright && chmod -R 777 $PLAYWRIGHT_BROWSERS_PATH
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ENV GRADLE_VERSION 7.1.1
ARG GRADLE_DOWNLOAD_SHA256=bf8b869948901d422e9bb7d1fa61da6a6e19411baa7ad6ee929073df85d6365d
RUN set -o errexit -o nounset \
    && echo "Downloading Gradle" \
    && wget --no-verbose --output-document=gradle.zip "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
    && echo "Checking download hash" \
    && echo "${GRADLE_DOWNLOAD_SHA256} *gradle.zip" | sha256sum --check - \
    && echo "Installing Gradle" \
    && unzip gradle.zip \
    && rm gradle.zip \
    && mv "gradle-${GRADLE_VERSION}" "${GRADLE_HOME}/" \
    && ln --symbolic "${GRADLE_HOME}/bin/gradle" /usr/bin/gradle \
    && echo "Testing Gradle installation" \
    && gradle --version \
COPY ./scripts /home/gradle
RUN cd scripts && ./download_driver_for_all_platforms.sh && \
    gradle -x test build \
CMD ["gradle", "test"]

