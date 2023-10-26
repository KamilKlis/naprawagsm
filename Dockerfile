FROM maven:amazoncorretto as MAVEN_BUILD
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn package

FROM amazoncorretto:19.0.2
EXPOSE 8080
COPY --from=MAVEN_BUILD /target/naprawagsm-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]