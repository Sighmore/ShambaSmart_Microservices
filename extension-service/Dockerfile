FROM eclipse-temurin:17-jdk
# Set the working directory
WORKDIR /app
# Copy the JAR file into the container
COPY target/auth-service-0.0.1-SNAPSHOT.jar /app/auth-service.jar
# Expose the port the app runs on
EXPOSE 8087
# Run the application
ENTRYPOINT ["java", "-jar", "auth-service.jar"]