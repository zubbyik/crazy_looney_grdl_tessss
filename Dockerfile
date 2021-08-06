FROM gradle:7.1.1-jdk11
COPY . .
RUN gradle test