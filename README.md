# wotTankRating
Simple website for rating and choosing preffered equipment build using:
- Spring Boot
- Maven
- Java 25

### Prerequirements:
- Java 25
- free Postgres database (in docker for example)

### Set-up database
1) in file **src/main/resources/application.properties**
`spring.jpa.hibernate.ddl-auto=none` -> `spring.jpa.hibernate.ddl-auto=create`
2) configure connetion details
3) run the code<br>
4) switch it back to none

### Running the app
**Linux/MacOS**

`./mvnw spring-boot:run` 

**Windows**

`mvnw.cmd spring-boot:run`

After that it should be running at `http://localhost:8080/`
