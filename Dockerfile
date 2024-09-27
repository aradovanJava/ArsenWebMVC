FROM eclipse-temurin:21-jdk-alpine
COPY target/ArsenWebMVC-1.jar demo.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/demo.jar"]