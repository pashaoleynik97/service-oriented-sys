FROM openjdk:17
WORKDIR /app

# Copy the built JAR from Gradle's output directory
COPY build/libs/userservice-0.0.1-SNAPSHOT.jar app.jar

# Run the app
CMD ["java", "-jar", "app.jar"]