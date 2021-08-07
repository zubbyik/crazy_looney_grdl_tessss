FROM gradle:7.1.1-jdk11
RUN apt-get update; apt-get install -y curl \
    && curl -sL https://deb.nodesource.com/setup_14.x | bash - \
    && apt-get install -y nodejs \
    && curl -L https://www.npmjs.com/install.sh | sh \
    && echo "Checking If Node and NPM was installed" \
    && node --version \
    && npm --version \
    && npm init -y \
    && npm i -D playwright \
COPY build.gradle /home/gradle
RUN gradle
COPY . .
CMD ["gradle", "check"]