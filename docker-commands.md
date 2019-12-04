# Docker Commands

## Images
- build
- images
- history
- load
- pull
- push
- rmi
- save
- search
- tag
- commit

## Containers
- run
- start
- stop
- kill
- cp
- create
- exec
- export
- import 
- logs
- pause
- unpause
- port
- ps
- update
- rename
- restart
- stats
- top
- rm
- attach
- diff
- waot

## Other Commands
- version
- login
- logout
- events
- info
- inspet

## Order of execution
- docker version
- docker pull
- docker run
- docker ps
- docker ps -a
- docker exec
- docker stop
- docker kill
- docker commit
- docker login
- docker push
- docker images
- docker rm
- docker rmi
- docker build

## Flow -1
- docker version
- docker login
- docker pull
- docker run
- docker ps
- docker ps -a
- docker exec
- docker stop
- docker kill

```
docker version
docker login -u stacksimplify -p <password>
docker pull stacksimplify/dockerintro-springboot-helloworld-rest-api:1.0.0-RELEASE
docker images
docker run -p 80:8080 -d stacksimplify/dockerintro-springboot-helloworld-rest-api:1.0.0-RELEASE
http://localhost/hello
docker ps, docker ps -a, docker ps -a -q
docker exec -it pensive_pascal /bin/sh
docker stop pensive_pascal
docker start pensive_pascal
docker kill pensive_pascal
docker rm pensive_pascal
docker rmi 
```




