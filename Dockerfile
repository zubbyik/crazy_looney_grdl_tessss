FROM gradle:7.1.1-jdk11
COPY build.gradle /home/gradle
RUN gradle
COPY . .
CMD ["gradle", "test"]