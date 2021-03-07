# Movie App with Spring, Thyemeleaf, JPA, Maven

## Technologies used:

- **Spring Framework**:
- **Spring Boot**
- **Spring Data JPA with Hibernate**
- **Thymeleaf**
- **MySQL JDBC Driver**:
- **Maven**
- **Spring Security** : Used   for authentication and access control.
- **MySQL Full Text Search :** Full-Text Search in MySQL server lets users run full-text queries against character-based data in MySQL tables.This technology was used to search by movie name, type and actor name.
- **JUnit** : Used for test the  project.

##  MySQL Tables:

 `users` :    (primary key)  user_id , username, password , enabled
 `roles` :   (primary key) role_id, name
 `users_roles` : (primary key) user_id, (foreign key) role_id
 

 Permission Details:
 ADMIN  :    View, Create,Edit and Delete Movies and Actors
 USER   :    View , Edit and Create Movies and Actors
 
 
  There can be more than one actor in a movie.
 So used **One-To-Many**  relationship between movie and actor table.
 
  `actor` :    (primary key)  id , name, role , (foreign key) movie_id
   `movie` :    (primary key)  id ,name, year, type, explanation, media, language
   


## Installation


Download the zip file./

You can build a jar file and run it from the command line:

```sh
mvn clean install
```
```sh
java -jar target/MovieApp-0.0.1-SNAPSHOT.jar
```
Or you can run it from Maven directly using the Spring Boot Maven plugin.


```sh
mvn spring-boot:run
```
