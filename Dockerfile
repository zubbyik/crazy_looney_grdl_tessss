FROM gradle:7.1.1-jdk11
COPY . .
CMD ["gradle", "test"]