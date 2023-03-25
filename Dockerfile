FROM amazoncorretto:17

COPY target/api-0.0.1-SNAPSHOT.jar api.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/api.jar"]