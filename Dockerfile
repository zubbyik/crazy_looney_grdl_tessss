FROM gradle:7.1.1-jdk11
WORKDIR /home
RUN DEBIAN_FRONTEND=noninteractive /bin/bash gradle init -Ptype=basic
COPY build.gradle .
RUN /bin/bash gradlew build -x test
COPY . .
CMD ["gradle", "test"]
