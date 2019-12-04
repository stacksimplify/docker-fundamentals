# Docker Fundamental Flows

## Flow-1: Pull existing Docker Image from Docker Hub and Run it as a Container

#### Step-1: Verify Docker version and also login to Docker Hub
```
docker version
docker login
```

#### Step-2: Pull Image from Docker Hub
```
docker pull stacksimplify/dockerintro-springboot-helloworld-rest-api:1.0.0-RELEASE
```

#### Step-3: Run the downloaded Docker Image & Access the Application
- Copy the docker image name from Docker Hub
```
docker run --name app1 -p 80:8080 -d stacksimplify/dockerintro-springboot-helloworld-rest-api:1.0.0-RELEASE
http://localhost/hello
```

#### Step-4: List Running Containers
```
docker ps
docker ps -a
docker ps -a -q
```

#### Step-5: Connect to Container Terminal
```
docker exec -it <container-name> /bin/sh
```

#### Step-6: Container Stop, Start 
```
docker stop <container-name>
docker start  <container-name>
```

#### Step-7: Remove Container 
```
docker rm <container-name>
```

### Step-8: Remove Image
```
docker image  <image-id>
```

## Flow-2: Create a new Docker Image, Run as Container and Push to Docker Hub
#### Step-1: Run the base Nginx container
- Access the URL http://localhost
```
docker run --name mynginxdefault -p 80:80 -d nginx
docker ps
```

#### Step-2: Create Dockerfile and copy our customized index.html
```
FROM nginx
COPY index.html /usr/share/nginx/html
```

#### Step-3: Build Docker Image & run it
```
docker build -t stacksimplify/mynginx_image1:v1 .
docker run --name mynginx1 -p 80:80 -d stacksimplify/mynginx_image1:v1
```

#### Step-4: Tag & push the Docker image to docker hub
```
docker images
docker tag stacksimplify/mynginx_image1:v1 stacksimplify/mynginx_image1:v1-release
docker push stacksimplify/mynginx_image1:v1-release
```
#### Step-5: Verify the same on docker hub
- Login to docker hub 
- Url: https://hub.docker.com/repositories