FROM gradle:7.1.1-jdk11
RUN gradle init
COPY build.gradle /home/gradle
COPY . .
RUN gradle test