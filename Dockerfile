FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8081
COPY target/dockerdeployment-0.0.1-SNAPSHOT.jar dockerDevop.jar
ENTRYPOINT ["java","-jar","dockerDevop.jar"]
