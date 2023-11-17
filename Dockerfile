# Stage 1: Build stage
FROM maven:3.6.0-jdk-13-alpine AS build

# Set the working directory inside the container
WORKDIR /usr/src/e-health-app

# Copy the contents of the current directory to the working directory
COPY . .

# Build the Maven project, skipping tests
RUN mvn clean install -DskipTests -X

# Remove Maven and its dependencies
RUN apk --no-cache del maven

# Stage 2: Deployment stage
FROM openjdk:17-jdk-slim AS deploy

# Set the working directory inside the container
WORKDIR /opt/e-health-app

# Copy the JAR file from the build stage to the deployment stage
COPY --from=build /usr/src/e-health-app/target//*.war e-health-app.war

# Stage 3: WildFly stage
FROM jboss/wildfly:latest

# Set the working directory inside the container
WORKDIR /opt/jboss/wildfly/standalone/deployments/

# Copy the WAR file from the deploy stage to the WildFly deployment directory
COPY --from=deploy /opt/e-health-app/e-health-app.war .

# Expose port 8080 for the application
EXPOSE 8080

# Start WildFly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
