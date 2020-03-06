#
# Created using tutorial: https://spring.io/guides/gs/spring-boot-docker/
# Starts the spring services for the project
#

# Extends an existing Alpine Linux imate with java 8 already installed from the public Docker Hub.
# @see https://hub.docker.com/_/openjdk
FROM openjdk:8-jdk-alpine

# This is just a variable you can use throughout the Dockerfile
ARG JAR_FILE=target/*.jar

# These commented out lines will create a spring user on the linux so the app doesn't run as root
# I dont care if it runs as root, so I commented them out
# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring

# This copies the spring boot jar (created from the mvn package command)
# from your local directory to the Docker image we are creating.
# When the image is created, app.jar will be in /app.jar of the linx instance.
# There is no need to create a big directory structure, just leave it in root.
COPY ${JAR_FILE} app.jar

# THIS DOES NOTHING. Its just a comment that lets the image author tell the person
# running a container that this image binds to these ports in the container.
# You bind container ports to your local machine when you run the container. See the
# docker run -p argument command in docker-run.sh
EXPOSE 8080 8082

# Specifies the command to run when the container starts.
# This starts spring boot project when the container instance runs.
ENTRYPOINT ["java", "-jar", "app.jar"]