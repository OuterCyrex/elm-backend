FROM openjdk:17
WORKDIR /app
COPY target/elm-1.0-SNAPSHOT.jar elm-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "elm-1.0-SNAPSHOT.jar"]
EXPOSE 8080
