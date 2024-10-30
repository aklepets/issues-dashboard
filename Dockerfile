FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/issues-dashboard-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8000

LABEL authors="aklepets"

ENTRYPOINT ["java", "-jar", "app.jar"]