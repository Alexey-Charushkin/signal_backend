FROM eclipse-temurin:17-jdk-alpine as builder
WORKDIR /app
COPY . /app
RUN ./mvnw clean package
CMD ["java", "-jar", "./target/backend-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080