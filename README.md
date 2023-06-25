# Springboot Docker template

### Getting started

#### Installation

Install Maven (mvn), Docker and Java in your computer.
Run the following without error to check if all your your versions are alright:
```
java -version
mvn -v
docker -v
```

#### Dockerfile and Docker-compose
Make sure to change the name of your Dockerfile application (demo to whatever your application may be).
Before running anything in Docker, make sure your application runs correctly. I left some useful application properties in resources, so you can change them as you wish. After that, run the following to repackage your project:
```
mvn package spring-boot:repackage
```
This will generate a .jar file in your package folder.

Now, you can run the docker-compose as follows in the terminal:
```
docker compose -f ./docker-compose.yaml up
```
If both containers are running fine and without errors, then you can check localhost:8080 or connect your database to a database manager.

### Antes de correr Springboot

Cuando se crea la base de datos de Docker, es necesario crear los tipos de datos antes de crear los datos con Springboot.

#### Authority Types
```sql
CREATE TYPE public.authority_type AS ENUM (
	'ROLE_PARENT',
	'ROLE_ADMIN',
	'READ',
	'WRITE');
```

#### Alert Types
```sql
CREATE TYPE public.alert_type AS ENUM (
	'BLOCK_ENTRY',
	'SOLICIT_UNBLOCK',
	'PHONE_TIME_EXCEEDED');
```

#### Device Types
```sql
CREATE TYPE public.device_type AS ENUM (
	'TABLET',
	'PHONE',
	'LAPTOP',
	'PC');
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#using.devtools)
* [Docker](https://docs.docker.com/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

