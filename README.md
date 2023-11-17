# Dockerfile Explanation

This Dockerfile is a set of instructions that tells Docker how to build and run your Java application using Maven, OpenJDK, and WildFly.

## **Stage 1: Build Stage**

```dockerfile
# Use the official Maven image as the base image
FROM maven:3.6.0-jdk-13-alpine AS build

# Set the working directory inside the container
WORKDIR /usr/src/e-health-app

# Copy the contents of the current directory to the working directory
COPY . .

# Build the Maven project, skipping tests
RUN mvn clean install -DskipTests -X

# Remove Maven and its dependencies to reduce the image size
RUN apk --no-cache del maven
```

-   **Explanation:**
    -   This stage uses a base image provided by Maven, a tool for building Java projects.
    -   It sets the working directory inside the container to `/usr/src/e-health-app`.
    -   It copies the contents of your local directory into the container.
    -   It builds the Maven project, skipping tests for faster building.
    -   It removes Maven and its dependencies to make the final image smaller.

## **Stage 2: Deployment Stage**

```dockerfile
# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-slim AS deploy

# Set the working directory inside the container
WORKDIR /opt/e-health-app

# Copy the JAR file from the build stage to the deployment stage
COPY --from=build /usr/src/e-health-app/target//*.war e-health-app.war
```

-   **Explanation:**
    -   This stage uses the official OpenJDK 17 image as the base image.
    -   It sets the working directory inside the container to `/opt/e-health-app`.
    -   It copies the WAR file (Web Application Archive) from the previous build stage to the deployment stage.

## **Stage 3: WildFly Stage**

```dockerfile
# Use the latest JBoss WildFly image as the base image
FROM jboss/wildfly:latest

# Set the working directory inside the container
WORKDIR /opt/jboss/wildfly/standalone/deployments/

# Copy the WAR file from the deploy stage to the WildFly deployment directory
COPY --from=deploy /opt/e-health-app/e-health-app.war .

# Expose port 8080 for the application
EXPOSE 8080

# Start WildFly when the container runs
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
```

-   **Explanation:**
    -   This stage uses the latest JBoss WildFly image as the base image.
    -   It sets the working directory inside the container to `/opt/jboss/wildfly/standalone/deployments/`.
    -   It copies the WAR file from the previous deployment stage to the WildFly deployment directory.
    -   It exposes port 8080 to allow access to the application.
    -   It starts WildFly when the container runs.

### Usage Instructions

1. **Build the Docker Image:**

    ```bash
    docker build -t e-health-app .
    ```

2. **Run the Docker Container:**

    ```bash
    docker run -p 8081:8080 e-health-app
    ```

3. **Access the Application:**
   Open your web browser and visit [http://localhost:8081/e-health-app](http://localhost:8081/e-health-app) to interact with the E-Health Application.

Remember to replace `e-health-app` with your preferred image name. This Dockerfile is a multi-stage build, optimizing the resulting Docker image size and only including necessary dependencies for runtime.
