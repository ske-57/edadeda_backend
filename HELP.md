# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.5/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.5/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.5/reference/data/sql.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Maven Commands

```bash
mvn clean
```
Purpose: Deletes the target directory where compiled files, JAR/WAR files, and temporary build data are stored.

Use case: Run before building to remove old artifacts.

```bash
mvn package
```
Purpose: Compiles the project, runs tests, and packages the project into a distributable format (JAR, WAR) in the target directory.

Use case: When you want to produce a file ready for deployment or execution.

```bash
mvn install
```
Purpose: Does everything package does, plus installs the artifact into the local Maven repository (~/.m2/repository).

Use case: If other projects on your machine need to use this artifact as a dependency.