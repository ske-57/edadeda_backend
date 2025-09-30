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

## Documentation

### App start instructions
Before starting this app on local PC must be installed:
1. Maven
2. Java 22

#### Next step is run this commands:
```bash
mvn clean package
```

```bash
java -jar target/edadeda_backend-0.0.3-beta.jar
```
#### In console u will see the port and confirmation of starting app:
<h6>Started EdadedaBackendApplicationTests in `x.xxx` seconds.</h6>


App is running. Available API Methods and Swagger Documentation.

#### For opening Swagger API Documentation:
Move to ```http://localhost:8089/docs``` in google/yandex and e.t.c
