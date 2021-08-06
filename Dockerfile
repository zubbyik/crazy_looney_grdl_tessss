FROM gradle:7.1.1-jdk11
COPY build.gradle .
RUN gradle clean
COPY . .
RUN gradle clean test