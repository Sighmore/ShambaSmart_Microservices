# Use official lightweight OpenJDK runtime image
FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/notification-service-1.0.0-SNAPSHOT.jar notification-service.jar

# Expose the port Eureka server runs on
EXPOSE 8089

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "notification-service.jar"]
