FROM gradle:7.1.1-jdk11
WORKDIR /home
COPY gradlew .
COPY build.gradle .
RUN /bin/bash gradlew build -x test
COPY . .
CMD ["gradle", "test"]
