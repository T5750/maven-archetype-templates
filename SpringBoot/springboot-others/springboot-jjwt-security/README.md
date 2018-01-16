# springboot-jjwt-security

## Runtime Environment
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Spring Framework 4.3.8.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Boot 1.5.3.RELEASE](https://projects.spring.io/spring-boot)
- [Spring Security 4.2.2 RELEASE](http://projects.spring.io/spring-security)
- [jjwt 0.7.0](https://github.com/jwtk/jjwt)

## Usage
Just start the application with the Spring Boot maven plugin (`mvn spring-boot:run`). The application is
running at [http://localhost:8080](http://localhost:8080).

There are three user accounts present to demonstrate the different levels of access to the endpoints in
the API and the different authorization exceptions:
```
Admin - admin:admin
User - user:password
Disabled - disabled:password (this user is disabled)
```

There are three endpoints that are reasonable for the demo:
```
/auth - authentication endpoint with unrestricted access
/persons - an example endpoint that is restricted to authorized users (a valid JWT token must be present in the request header)
/protected - an example endpoint that is restricted to authorized users with the role 'ROLE_ADMIN' (a valid JWT token must be present in the request header)
```

I've written a small Javascript client and put some comments in the code that hopefully makes this demo
understandable.

## Results
![Screenshot from running application](http://s1.wailian.download/2018/01/09/screenshot-jwt-spring-security-demo.png "Screenshot JWT Spring Security Demo")

## Tips
* Commits on Sep 11, 2017

## Links
- [jwt-spring-security-demo](https://github.com/szerhusenBC/jwt-spring-security-demo)
