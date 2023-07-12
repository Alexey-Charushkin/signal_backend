#FROM eclipse-temurin:17-jdk-alpine as builder
#WORKDIR /app
#COPY . /app
#RUN ./mvnw clean package
#CMD ["java", "-jar", "./target/backend-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8080



FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY . /app

RUN ./mvnw clean package


FROM openjdk:17-jdk-slim 
COPY --from=builder /app/target/backend-0.0.1-SNAPSHOT.jar /usr/local/lib/backend.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/backend.jar"]
