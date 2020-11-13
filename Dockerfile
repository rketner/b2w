FROM openjdk:8u121-jre-alpine
COPY ./target/*.jar /app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]