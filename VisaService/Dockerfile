FROM openjdk:8-jdk-alpine
COPY target/VisaService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java -jar /app.jar -Dspring.config.location=file:/config/application.properties
EXPOSE 8080