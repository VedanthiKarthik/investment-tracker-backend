# Use official Eclipse Temurin Java 25 image
FROM eclipse-temurin:25-jdk

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot jar into the container
COPY target/pit-0.0.1-SNAPSHOT.jar app.jar

# Expose application port (default Spring Boot)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]