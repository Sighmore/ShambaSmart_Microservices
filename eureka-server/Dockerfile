# Use official lightweight OpenJDK runtime image
FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/eureka-server-1.0.0-SNAPSHOT.jar eureka-server.jar

# Expose the port Eureka server runs on
EXPOSE 8761

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
