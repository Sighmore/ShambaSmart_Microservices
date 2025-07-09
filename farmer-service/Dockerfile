# Use official lightweight OpenJDK runtime image
FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/farmer-service-1.0.0-SNAPSHOT.jar farmer-service.jar

# Expose the port Eureka server runs on
EXPOSE 8082

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "farmer-service.jar"]
