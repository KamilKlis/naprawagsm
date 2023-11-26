FROM maven:3.9.5-amazoncorretto-17-debian AS MAVEN_BUILD
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn clean package

FROM openjdk:21-slim-bookworm
EXPOSE 8080
COPY --from=MAVEN_BUILD /target/naprawagsm-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]