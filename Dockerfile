# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-17-slim AS builder

# Set the working directory
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the application using Maven
RUN mvn clean package

# Use a lightweight base image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage to the final image
COPY --from=builder /app/target/coffee-order-microservice.jar .

# Specify the command to run your application
CMD ["java", "-jar", "coffee-order-microservice.jar"]
