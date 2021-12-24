FROM adoptopenjdk/openjdk8:latest
EXPOSE 8082/http
COPY target/helloworld2-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
