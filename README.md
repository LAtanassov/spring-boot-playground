# Spring Boot Playground

using [Spring Boot 2.2.4-RELEASE](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/html/)
 
already tried experiments:
* [Flyway](https://flywaydb.org/) for database schema versioning
* [Amazon Corretto JDK 11](https://aws.amazon.com/corretto/)
* [SpringFox](https://springfox.github.io/springfox/)  for swagger support
* [Project Lombox](https://projectlombok.org/) to reduce boilerplate code
* [Cloud Code](https://cloud.google.com/code/docs/intellij/quickstart-IDEA), [Skaffold](https://skaffold.dev/) and [Jib](https://github.com/GoogleContainerTools/jib) for continuous k8s development
* [Spring Boot DevTools] (https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/html/using-spring-boot.html#using-boot-devtools) in Docker

ongoing experiments:
* local development of [AWS ECS](https://aws.amazon.com/ecs/) using this [guide](https://aws.amazon.com/blogs/compute/a-guide-to-locally-testing-containers-with-amazon-ecs-local-endpoints-and-docker-compose/)

## Continuous k8s Development with Cloud Code
 
 TODO

## Continuous Development with Spring Boot DevTools Remote in Docker

**Situation**: Your workload runs on unix, but you develop for some reason on MS Windows.  
**Solution**: Build a Docker image with Spring Boot DevTools support, run the Docker container & connect with your IDE to it.

```sh
# runs postgres, assuming you have a local dns `local-postgres` pointing to localhost
$> docker run -p 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_DB=user-crud -d postgres
# builds docker image with mvn profile `dev`, which includes Spring Boot DevTools
$> mvn compile -P dev jib:dockerBuild -Dimage=user-crud-dev
# runs user-crud with Spring profile `dev`
$> docker run -it --rm -p 8080:8080 -e spring.profiles.active=dev -e spring.datasource.url=jdbc:postgresql://192.168.0.143:5432/user-crud user-crud-dev
```

Open your IDE with mvn project `user-crud`.  
Run `org.springframework.boot.devtools.RemoteSpringApplication` with 
* JVM options `-Dspring.profiles.active=dev` and 
* Program arguments `http://localhost:8080`  

Some IDE's does not build on file save, therefore check your IDE configuration.