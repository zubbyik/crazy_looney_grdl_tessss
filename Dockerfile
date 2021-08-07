FROM gradle:7.1.1-jdk8
COPY build.gradle /home/gradle
RUN gradle
COPY . .
CMD ["gradle", "check"]