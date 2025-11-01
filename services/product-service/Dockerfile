# Product Service Dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY build/libs/product-service-*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
