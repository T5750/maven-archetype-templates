# springboot-jpa-angularjs

## Runtime Environment
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Spring Framework 4.3.7.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Boot 1.5.2.RELEASE](https://projects.spring.io/spring-boot)
- [Spring Data JPA 1.11.1.RELEASE](http://projects.spring.io/spring-data-jpa/)
- [AngularJS 1.5.8](https://angularjs.org/)
- [Hibernate 5.0.12.Final](http://hibernate.org/orm)
- [MySQL 5.6](http://www.mysql.com/)
- [H2 1.4.193](http://h2database.com/html/main.html)

## Back-end
### Spring Boot Application [Main class]
- `SpringBootCRUDApp`

### JPA configuation
- `JpaConfiguration`

### Property file [application.yml]

### Spring-Data repositories
- `UserRepository`

### Populate MySQL database
- `springboot-jpa-angularjs.sql`

## Front-end
### AngularJs [ui-router based app]
- `src/main/resources/static/js/app.js`
- `src/main/resources/static/js/UserService.js`
- `src/main/resources/static/js/UserController.js`

## Running the application
Open your browser and navigate to `http://localhost:8080/SpringBootCRUDApp/`
![SpringBootCRUDApp_img2](http://s1.wailian.download/2018/01/19/SpringBootCRUDApp_img2.png)
![SpringBootCRUDApp_img3](http://s1.wailian.download/2018/01/19/SpringBootCRUDApp_img3.png)

## Tips
deleted files:
- `css/bootstrap.css`
- `js/lib/angular.min.js`
- `js/lib/angular-ui-router.min.js`
- `js/lib/localforage.min.js`
- `js/lib/ngStorage.min.js`

## Links
- [Spring Boot + AngularJS + Spring Data + JPA CRUD App Example](http://websystique.com/spring-boot/spring-boot-angularjs-spring-data-jpa-crud-app-example/)
