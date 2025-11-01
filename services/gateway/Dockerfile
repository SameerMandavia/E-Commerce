# API Gateway Dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY build/libs/gateway-*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]
