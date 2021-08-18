# spring-todo

Todo app built with Spring Boot. Learn from the [tutorial](https://ithelp.ithome.com.tw/users/20118857/ironman/3007).

- [spring-todo](#spring-todo)
  - [Architecture](#architecture)
    - [DAO](#dao)
  - [Dependencies and Frameworks](#dependencies-and-frameworks)
    - [H2 Database](#h2-database)
    - [Spring Boot DevTools](#spring-boot-devtools)
    - [Lombok](#lombok)
    - [Spring Data JPA](#spring-data-jpa)
    - [Junit](#junit)
    - [Mockito](#mockito)
    - [MockMvc](#mockmvc)
    - [JWT](#jwt)
  - [Tools](#tools)
    - [Postman](#postman)
    - [Swagger](#swagger)
    - [REST Client](#rest-client)

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

## Dependencies and Frameworks

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

AAA patern:

- Arrange
- Act
- Assert

### Mockito

A mocking framework for unit tests in Java.

### MockMvc

Test web layer.

### JWT

JSON Web Token. Usually for auth.

## Tools

### Postman

[Postman](https://www.postman.com/)
is an API platform for building and using APIs.

### Swagger

[Swagger](https://swagger.io/) UI: Visualize OpenAPI Specification definitions.

### REST Client

```text
Method Request-URI HTTP-Version
Header-field: Header-value

Request-Body
```

- IntelliJ IDEA - [HTTP Client](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html#creating-http-request-files)

- VSCode - [REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client)
