FROM gradle:7.1.1-jdk11
COPY build.gradle .
RUN ./gradlew
COPY . .
RUN ./gradlew clean test