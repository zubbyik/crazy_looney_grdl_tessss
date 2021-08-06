FROM gradle:7.1.1-jdk11
COPY --chown=gradle:gradle . /home/gradle/src
RUN gradle test