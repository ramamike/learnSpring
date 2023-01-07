#creates a layer from the jdk Docker image
FROM openjdk:11
#COPY adds files from your Docker client’s current directory.
COPY target/docker-0.0.1-SNAPSHOT.jar /demo.jar
#CMD specifies what command to run within the container.
CMD ["java", "-jar", "demo.jar"]  
