# wotTankRating
Simple website for rating and choosing preffered equipment build using:
- Spring Boot
- Maven
- Java 25

### Prerequirements:
- Java 25
- free Postgres database (in docker for example)

### Set-up database
if you don't have an right database with the right scheme
  - in file **src/main/resources/application.properties** change this line from **none** to **create** and configure the connection details
`spring.jpa.hibernate.ddl-auto=none` -> `spring.jpa.hibernate.ddl-auto=create`

run the code<br>
switch it back to none

### Running the app
**Linux/MacOS**

`./mvnw spring-boot:run` 

**Windows**

`mvnw.cmd spring-boot:run`

After that it should be running at `http://localhost:8080/`
