# SecureRESTApiWithBasicAuthentication

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 4.3.1.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Security 4.1.1 RELEASE](http://projects.spring.io/spring-security)

## What is Basic Authentication?
[Basic Authentication](https://en.wikipedia.org/wiki/Basic_access_authentication) provides a solution for this problem, although not very secure. With Basic Authentication, clients send it’s Base64 encoded credentials **with each request**, using HTTP [Authorization] header . That means each request is independent of other request and server may/does not maintain any state information for the client, which is good for scalability point of view.

### Basic Authentication & Spring Security
- `SecurityConfiguration`
- `CustomBasicAuthenticationEntryPoint`
### REST API
- `HelloWorldRestController`

## Running the application
### Using Client 1: Postman
Now select type as ‘Basic Auth’ from dropdown, fill in username/password [bill/abc123], click on ‘update request’.
![SpringBasicAuth_img2](http://s1.wailian.download/2018/01/18/SpringBasicAuth_img2.png)
![SpringBasicAuth_img3](http://s1.wailian.download/2018/01/18/SpringBasicAuth_img3.png)

### Using Client 2: RestTemplate based Java Application
- `SpringRestClient`

## Links
- [Secure Spring REST API using Basic Authentication](http://websystique.com/spring-security/secure-spring-rest-api-using-basic-authentication/)
