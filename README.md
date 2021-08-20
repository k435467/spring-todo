# spring-todo

Todo app built with Spring Boot. Learn from tutorials: [ithome ironman](https://ithelp.ithome.com.tw/users/20118857/ironman/3007) , [section.io](https://www.section.io/engineering-education/spring-boot-crud-api/).

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
  - [Dependency Injection](#dependency-injection)
    - [Constructor-based](#constructor-based)
    - [Setter-base](#setter-base)
    - [Field-base](#field-base)

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

## Dependency Injection

- Constructor-based dependency injection
- Setter-based dependency injection
- Field-based dependency injection

**@Component** is an annotation that allows Spring to automatically detect our custom beans. Spring will:

- Scan our app for classes anntated with @Component
- Instantiate them and inject any specified dependencies into them
- Inject them wherever needed

Specialized Stereotype Annotations:

- @Controller
- @Service
- @Repository
- @Component
- @CustomComponent

### Constructor-based

It is recommended for required dependencies allowing them to be immutable and preventing them to be null.

```java
@Component
public class ConstructorBasedInjection {

    private final InjectedBean injectedBean;

    @Autowired
    public ConstructorBasedInjection(InjectedBean injectedBean) {
        this.injectedBean = injectedBean;
    }

}
```

### Setter-base

It is recommended for optional dependencies.

```java
@Component
public class ConstructorBasedInjection {

    private InjectedBean injectedBean;

    @Autowired
    public void setInjectedBean(InjectedBean injectedBean) {
        this.injectedBean = injectedBean;
    }

}
```

### Field-base

Not recommended.

```java
@Component
public class ConstructorBasedInjection {

    @Autowired
    private InjectedBean injectedBean;

}
```
