**install docker** 
>curl -fsSL https://get.docker.com -o get-docker.sh

>DRY_RUN=1 sudo sh ./get-docker.sh

**mvn package**

**create docker file** \
>vim Dockerfile

#creates a layer from the jdk Docker image \
FROM openjdk:11

#COPY adds files from your Docker client’s current directory. \
COPY target/docker-0.0.1-SNAPSHOT.jar /demo.jar

#CMD specifies what command to run within the container \
CMD ["java", "-jar", "demo.jar"]

**build docker image**
>sudo docker build -t docker-package-only-build-demo:1.0-SNAPSHOP .

**run docker image** 
>sudo docker run -d -p 8083:8083 docker-package-only-build-demo:1.0-SNAPSHOP

**check** \
>sudo docker ps

