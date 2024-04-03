FROM amazoncorretto:17-alpine-jdk

COPY target/creditcar-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]