FROM adoptopenjdk/openjdk15
EXPOSE 8080
ARG JAR_FILE=target/movie.back-end-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} movie-api.jar
ENTRYPOINT ["java", "-jar", "/movie-api.jar"]