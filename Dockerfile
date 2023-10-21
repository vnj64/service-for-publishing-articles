FROM openjdk:11

ENV JAR_FILE=publishing-service-0.0.1-SNAPSHOT.jar

COPY target/$JAR_FILE /app/$JAR_FILE

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "publishing-service-0.0.1-SNAPSHOT.jar"]