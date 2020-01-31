# Spring Boot Playground

using [Spring Boot 2.2.4-RELEASE](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/html/)
 
already tried experiments:
* [Flyway](https://flywaydb.org/) for database schema versioning
* [Amazon Corretto JDK 11](https://aws.amazon.com/corretto/)
* [SpringFox](https://springfox.github.io/springfox/)  for swagger support
* [Project Lombox](https://projectlombok.org/) to reduce boilerplate code
* [Cloud Code](https://cloud.google.com/code/docs/intellij/quickstart-IDEA), [Skaffold](https://skaffold.dev/) and [Jib](https://github.com/GoogleContainerTools/jib) for continuous k8s development
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/html/using-spring-boot.html#using-boot-devtools) for continuous development locally or in Docker

ongoing experiments:
* [ECS Local Container Endpoints](https://github.com/awslabs/amazon-ecs-local-container-endpoints) for [AWS ECS](https://aws.amazon.com/ecs/) using this [guide](https://aws.amazon.com/blogs/compute/a-guide-to-locally-testing-containers-with-amazon-ecs-local-endpoints-and-docker-compose/)

## Database Schema Versioning with Flyway

**Situation**: Your workload uses a RDBMS and need database schema versioning.
**Solution**: Generate/Validate your database schema using JPA/Hibernate. Use Flyway to version your database schema. 
If you need highly optimized stored procedures add them to your database schema and call them with Spring Boot Data.  
**Security**: Separation of Duties: Flyway user needs rights to execute DDL, DCL; Service user needs rights to execute DML, TCL;  

## Continuous k8s Development with Cloud Code
 
**Situation**: Your workload runs in (managed) k8s in the cloud, you develop on your workstation. how to test the  integration?  
**Solution**: Continuous Development with Cloud Code, directly into your local minikube or Cloud k8s.

Install the Cloud Code Plugin for Intellij, Eclipse, VS Code and follow the instruction or run Skaffold in your command line.

## Continuous Development with Spring Boot DevTools Remote in Docker

**Situation**: Your workload runs on unix, but you develop for some reason on MS Windows.  
**Solution**: Build a Docker image with Spring Boot DevTools support, run the Docker container & connect with your IDE to it.

```sh
$> docker run -p 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_DB=user-crud -d postgres
$> mvn compile jib:dockerBuild -Dimage=user-crud
$> docker run -it --rm -p 8080:8080 \
-e spring.devtools.remote.secret="development" \
-e spring.datasource.url=jdbc:postgresql://192.168.0.143:5432/user-crud \
-e spring.datasource.username=postgres \
-e spring.datasource.password=password \
-e spring.jpa.show-sql=true \
-e spring.jpa.hibernate.ddl-auto=create-drop \
-e management.endpoints.web.exposure.include="*" \
user-crud
```

Open your IDE with mvn project `user-crud`.  
Run `org.springframework.boot.devtools.RemoteSpringApplication` with 
* JVM options `-Dspring.devtools.remote.secret="development"` and 
* Program arguments `http://localhost:8080`  

Some IDE's does not build on file save, therefore check your IDE configuration.
