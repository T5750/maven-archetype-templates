# SpringSecurityOAuth2

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 4.3.1.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Security 4.1.1 RELEASE](http://projects.spring.io/spring-security)
- [Spring Security OAuth 4.1.1 RELEASE](https://projects.spring.io/spring-security-oauth)

## What is OAuth2
OAuth2 is an standardized authorization protocol/framework. As per Official [OAuth2 Specification](https://tools.ietf.org/html/rfc6749):
> The OAuth 2.0 authorization framework enables a third-party application to obtain limited access to an HTTP service, either on behalf of a resource owner by orchestrating an approval interaction between the resource owner and the HTTP service, or by allowing the third-party application to obtain access on its own behalf.

### 1. OAuth2 Roles
- `resource owner`
- `resource server`
- `client`
- `authorization server`

### 2. OAuth2 Authorization Grant types
- `authorization code`: 授权码模式
- `implicit`: 简化模式
- `resource owner password credentials`: 密码模式
- `client credentials`: 客户端模式

### 3. OAuth2 Tokens
- `Access Token`
- `Refresh Token`

### 4. OAuth2 Access Token Scope
Client can ask for the resource with specific access rights using scope [want to access feeds & photos of this users facebook account], and authorization server in turn return scope showing what access rights were actually granted to the client [Resource owner only allowed feeds access, no photos e.g.].

## Let’s Get into Code
### 1. Resource Server
- `ResourceServerConfiguration`

### 2. Authorization Server
- `AuthorizationServerConfiguration`

### 3. Security Configuration
- `OAuth2SecurityConfiguration`
- `MethodSecurityConfig`

### 4. Endpoints and their purpose
- Attempt to access resources [REST API] without any authorization [will fail of-course].
    - GET ```http://localhost:8080/SpringSecurityOAuth2Example/user/```
- Ask for tokens[access+refresh] using **HTTP POST** on /oauth/token, with grant_type=password,and resource owners credentials as req-params. Additionally, send client credentials in Authorization header.
    - POST ```http://localhost:8080/SpringSecurityOAuth2Example/oauth/token?grant_type=password&username=bill&password=abc123```
- Ask for a new access token via valid refresh-token, using **HTTP POST** on /oauth/token, with grant_type=refresh_token,and sending actual refresh token. Additionally, send client credentials in Authorization header.
    - POST ```http://localhost:8080/SpringSecurityOAuth2Example/oauth/token?grant_type=refresh_token&refresh_token=094b7d23-973f-4cc1-83ad-8ffd43de1845```
- Access the resource by providing an access token using access_token query param with request.
    - GET ```http://localhost:8080/SpringSecurityOAuth2Example/user/?access_token=3525d0e4-d881-49e7-9f91-bcfd18259109```

### 5. Rest API
- `HelloWorldRestController`

### 6. Running the application
#### Client 1: Postman
First add an authorization header with client credentials [my-trusted-client/secret].
![SpringOAuth2_img2](http://s1.wailian.download/2018/01/17/SpringOAuth2_img2.png)
![SpringOAuth2_img3](http://s1.wailian.download/2018/01/17/SpringOAuth2_img3.png)

#### Client 2: RestTemplate based java application
- `SpringRestClient`

## Links
- [Secure Spring REST API using OAuth2](http://websystique.com/spring-security/secure-spring-rest-api-using-oauth2/)
- [理解OAuth 2.0](http://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html)
