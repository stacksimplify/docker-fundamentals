# Docker Fundamental Flows

## Flow-1: Pull existing Docker Image from Docker Hub and Run it as a Container

## Flow-2: Create a new Docker Image, Run as Container and Push to Docker Hub
- Run the base Nginx container
- Access the URL http://localhost
```
docker run --name mynginxdefault -p 80:80 -d nginx
docker ps
```

- Create Dockerfile and copy our customized index.html
```
FROM nginx
COPY index.html /usr/share/nginx/html
```
- Build Docker Image & run it
```
docker build -t stacksimplify/mynginx_image1:v1 .
docker run --name mynginx1 -p 80:80 -d stacksimplify/mynginx_image1:v1
```
- Tag & push the Docker image to docker hub
```
docker images
docker tag stacksimplify/mynginx_image1:v1 stacksimplify/mynginx_image1:v1-release
docker push stacksimplify/mynginx_image1:v1-release
```
- Verify the same on docker hub