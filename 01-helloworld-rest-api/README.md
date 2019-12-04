# Dockerize Spring Boot REST API Application

## Step-1: Pre-requsites - Create Simple SpringBoot HelloWorld REST API
- Create a simple Helloworld rest api
- In our case, we will downloas this from our course artifacts during project setup. 
- Run locally and test
    - Access Helloworld REST API
    - http://localhost:8080/hello
    - http://localhost:8080/hello-bean
```json
{
  "message": "Hello World Bean",
  "appversion": "V1"
}
```

## Step-2: Create Dockerfile
- Create Dockerfile on Application root folder

```
FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
```

## Step-3: Update pom.xml with spotify plugin
- Update the pom.xml with Spotify plugin
- For additional reference, please refer below link
- **Important Note: ** 
    - In the below pom.xml, please ensure we replace "stacksimplify" in repository tag with your docker hub id. 
    - <repository>stacksimplify/${project.name}</repository>
- https://github.com/spotify/dockerfile-maven
- https://mvnrepository.com/artifact/com.spotify/dockerfile-maven-plugin
```xml
			<!-- Docker Spotify Plugin -->
			<plugin>
				<groupId>com.spotify</groupId>
				<artifactId>dockerfile-maven-plugin</artifactId>
				<version>1.4.13</version>
				<executions>
					<execution>
						<id>default</id>
						<goals>
							<goal>build</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<repository>stacksimplify/${project.name}</repository>
					<tag>${project.version}</tag>
					<skipDockerInfo>true</skipDockerInfo>
				</configuration>
			</plugin>
```

## Step-4: Package as Docker image and Run locally on Docker Desktop.
- Run the below command from application root folder or run the same from Spring Tool Suite IDE
```
mvn clean package  
```
- Execute docker commands 
    - List docker images 
    - Run the docker image locally
```
docker images
docker run -p 80:8080 stacksimplify/springboot-helloworld-rest-api:1.0.0-RELEASE
```
- Access Helloworld REST API
    - http://localhost/hello
    - http://localhost/hello-bean
```json
{
  "message": "Hello World Bean",
  "appversion": "V1"
}
```

## Step-5: Push Docker Image to Docker Hub
- Pre-requisites
    - Create an account on docker hub 
    - https://hub.docker.com/
- Login to docker hub
- Push the newly created image to docker hub.     
```
docker login
docker push stacksimplify/springboot-helloworld-rest-api:1.0.0-RELEASE
docker push **YOUR DOCKERHUB REPO NAME**/springboot-helloworld-rest-api:1.0.0-RELEASE
```
- Verify the new repository with **1.0.0-RELEASE** tag should be displayed on Docker Hub.

## Step-6: Spring Boot - Docker Image Versioning
- Update version tag in pom.xml
```xml
	<version>2.0.0-RELEASE</version>
```
- Package the new image
```
mvn clean package
```
- Run the docker image locally (if required to test)
```
docker images
docker run -p 80:8080 stacksimplify/springboot-helloworld-rest-api:2.0.0-RELEASE
```
- Push the docker image to Docker Hub
```
docker push stacksimplify/springboot-helloworld-rest-api:2.0.0-RELEASE
```
- Verify the same in Docker Hub. New release tag **2.0.0-RELEASE** should bedisplayed

## Step-7: Run docker image in detached mode
- Run docker image in detached mode (no console output of spring boot application)
- So far we are running in foreground mode where we get the spring boot application console output. 
```
docker run -d -p 80:8080 stacksimplify/springboot-helloworld-rest-api:2.0.0-RELEASE
docker ps
```

## Step-8: Docker Essentinal commands 
- The belowa are the list of essential commands we are in need 

|     Commands                 |    Description                                  |
| ------------------------------- | --------------------------------------------- |
| docker ps | List all running containers |
| docker ps -a | List all containers stopped, running |
| docker stop container-id | Stop the container which is running |
| docker start container-id | Start the container which is stopped |
| docker restart container-id | Restart the container which is running |
| docker port container-id | List port mappings of a specific container |
| docker rm container-id or name | Remove the stopped container |
| docker rm -f container-id or name| Remove the running container forcefully |
| docker pull image-info | Pull the image from docker hub repository |
| docker pull stacksimplify/springboot-helloworld-rest-api:2.0.0-RELEASE | Pull the image from docker hub repository |
| docker exec -it container-name /bin/sh | Connect to linux container and execute commands in container |
| docker rmi image-id | Remove the docker image |
| docker logout | Logout from docker hub |
| docker login -u username -p password | Login to docker hub |
| docker stats | Display a live stream of container(s) resource usage statistics |
| docker top container-id or name | Display the running processes of a container |
| docker version | Show the Docker version information |

## Troubleshooting 
- Docker Desktop on mac has an issue with MAC **osxkeychain**
- To fix it perform the below steps.
- **Pre-requisite:** Refer below link for additional understanding
	- https://medium.com/@dakshika/error-creating-the-docker-image-on-macos-wso2-enterprise-integrator-tooling-dfb5b537b44e
- **Step-1:** Docker Desktop changes
	- Open Docker Desktop --> Preferences
	- Uncheck the option named **Securely store Docker logins in macOS keychain**
- **Step-2:** Go to **config.json** file in **.docker** folder		
	- Sample Reference Location: 
		- /Users/<userid>/.docker/config.json
		- ~/.docker/config.json
	- Remove the line **“credSstore” : “osxkeychain”,** in config.json


 