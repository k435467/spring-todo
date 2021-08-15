# spring-todo

Todo app built with Spring Boot.

- [spring-todo](#spring-todo)
  - [Architecture](#architecture)
    - [DAO](#dao)
  - [Packages](#packages)
    - [H2 Database](#h2-database)
    - [Spring Boot DevTools](#spring-boot-devtools)
    - [Lombok](#lombok)
    - [Spring Data JPA](#spring-data-jpa)
    - [Junit](#junit)

## Architecture

- Presentation Layer
- Business Layer
- Presistence Layer
- Database

--

- Controller
- Service Layer
- DAO
- Database

### DAO

Data Access Object. It provides an abstract interface and some specific data operations without exposing details of the database.

```java
public interface TodoDao extends CrudRepository<Todo, Integer> {}
```

## Packages

### H2 Database

A in memory database. It has a console webpage.

### Spring Boot DevTools

For hot reloading.

### Lombok

Java annotation lib which helps to reduce boilerplate code.

Lombok - IntelliJ IDEA Plugin

- @Getter
- @Setter
- @NoArgsConstructor
- @ToString

### Spring Data JPA

Java Persistence API. Hibernate is a ORM tool and an implementation of JPA.

javax.persistence.\*

- @Entity
- @Table
- @Id
- @GeneratedValue
- @Column

Interface:

- Repository
- CrudRepository
- PagingAndSortingRepository
- JpaRepository

### Junit

Run TEST with Coverage. (Element: Class% / Method% / Line%)

- org.junit.jupiter.api
- @Test
- assertEquals()
