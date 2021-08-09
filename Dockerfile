FROM mcr.microsoft.com/playwright/java
WORKDIR /home/imad
COPY pom.xml .
RUN mvn install -D skipTests --no-transfer-progress
ADD . .
RUN mvn clean test

