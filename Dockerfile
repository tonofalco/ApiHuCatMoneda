#Stage 1: Build the aplicacion
FROM eclipse-temurin:17-jdk AS builder

#Set the working directory
WORKDIR /app

#Copy the aplication code
COPY . .

#Build the application (requires Maven or Gradle)
RUN ./mvnw clean package -DskipTests

#Stage 2: Run the aplication
FROM eclipse-temurin:17-jre

#Set the working directory
WORKDIR /app

#Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

#Expose the port the app will run on
EXPOSE 9000

#Command to run the aplication
ENTRYPOINT [ "java", "-jar", "app.jar" ]