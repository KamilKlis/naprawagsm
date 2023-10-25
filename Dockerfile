FROM amazoncorretto:19.0.2
EXPOSE 8080
COPY target/naprawagsm-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]