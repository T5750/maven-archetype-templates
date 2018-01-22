# springboot-rest-api

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 4.3.7.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Boot 1.5.2.RELEASE](https://projects.spring.io/spring-boot)

## Short & Quick introduction to REST
### Main class
- `SpringBootRestApiApp`

### REST Controller
- `RestApiController`

This is what our REST API does:
- GET request to `http://localhost:8080/SpringBootRestApi/api/user/` returns a list of users
- GET request to `http://localhost:8080/SpringBootRestApi/api/user/1` returns the user with ID 1
- POST request to `http://localhost:8080/SpringBootRestApi/api/user/` with a user object as JSON creates a new user
- PUT request to `http://localhost:8080/SpringBootRestApi/api/user/3` with a user object as JSON updates the user with ID 3
- DELETE request to `http://localhost:8080/SpringBootRestApi/api/user/4` deletes the user with ID 4
- DELETE request to `http://localhost:8080/SpringBootRestApi/api/user/` deletes all the users

Detailed Explanation :
- `@RestController`
- `@RequestBody`
- `@ResponseBody`
- `ResponseEntity`
- `@PathVariable`
- `MediaType`

### Testing the API
![SpringBootRestApi_img1](http://www.wailian.work/images/2018/01/22/SpringBootRestApi_img1.png)

- Use POST, specify the content in body, select `content-type` as `application/json`
- `{"name":"Sarah","age":51,"salary":134}`

![SpringBootRestApi_img4](http://www.wailian.work/images/2018/01/22/SpringBootRestApi_img4.png)

### Writing REST Client using RestTemplate
HTTP Methods and corresponding RestTemplate methods:
- HTTP GET : getForObject, getForEntity
- HTTP PUT : put(String url, Object request, String…​urlVariables)
- HTTP DELETE : delete
- HTTP POST : postForLocation(String url, Object request, String…​ urlVariables), postForObject(String url, Object request, Class responseType, String…​ uriVariables)
- HTTP HEAD : headForHeaders(String url, String…​ urlVariables)
- HTTP OPTIONS : optionsForAllow(String url, String…​ urlVariables)
- HTTP PATCH and others : exchange execute

Custom Rest client , consuming the REST services created earlier.
- `SpringBootRestTestClient`

## Links
- [Spring Boot Rest API Example](http://websystique.com/spring-boot/spring-boot-rest-api-example/)
