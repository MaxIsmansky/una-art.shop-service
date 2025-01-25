# Use the official Gradle image for building
FROM --platform=linux/amd64 gradle:latest AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper files and build.gradle to cache dependencies
COPY gradle/ ./gradle
COPY gradlew ./
COPY build.gradle ./
COPY settings.gradle ./

# Cache Gradle dependencies
RUN ./gradlew dependencies --no-daemon --parallel

# Copy the rest of the application files
COPY src ./src

# Build the application
RUN ./gradlew build --no-daemon

# Use the official OpenJDK runtime image
FROM --platform=linux/amd64 openjdk:21-jdk-slim

# Set the working directory for the application
WORKDIR /app

# Copy the built application JAR from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port the application runs on (adjust if necessary)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
