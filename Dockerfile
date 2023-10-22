FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar bookshelfsber-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/publishing-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080