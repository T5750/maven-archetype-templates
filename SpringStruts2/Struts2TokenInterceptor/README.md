# Struts2TokenInterceptor

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Struts Framework 2.3.15](http://struts.apache.org)

## Short & Quick introduction
### Struts2 Token Interceptor Example Configuration Files
- `struts.xml`

### Struts2 Token Interceptor Example Action Class
- `UpdateUserAction.java`

### Struts2 Token Interceptor Example JSP Pages
- `update.jsp`
- `update_success.jsp`
- `invalid_token.jsp`

### Results
![Struts2-token-input](http://www.wailian.work/images/2018/01/25/Struts2-token-input-450x177.png)
![Struts2-token-success](http://www.wailian.work/images/2018/01/25/Struts2-token-success-450x206.png)
![Struts2-token-reload-page](http://www.wailian.work/images/2018/01/25/Struts2-token-reload-page-450x196.png)
![Struts2-token-invalid](http://www.wailian.work/images/2018/01/25/Struts2-token-invalid-450x263.png)

### How Struts2 Token Interceptor Works
1. When a request is made to the update action, Struts2 tags API generates a unique token and set it to the session. The same token is sent in the HTML response as hidden field.
2. When the form is submitted with token, it is intercepted by token interceptor where it tries to fetch the token from the session and validate that it’s same as the token received in the request form. If token is found in session and validated then the request is forwarded to the next interceptor in the chain. Token interceptor also removes the token from the session.
3. When the same form is submitted again, token interceptor will not find it in the session. So it will add an action error message and return invalid.token result as response. You can see this message in above image for invalid_token.jsp response. This way token interceptor make sure that a form with token is processed only once by the action.
4. If we use tokenSession interceptor, rather than returning invalid token response, it tries to return the same response as the returned by the first action with same token. This implementation is done in the TokenSessionStoreInterceptor class that saves the response for each token in the session.
5. We can override the action error message sent by token interceptor through i18n support with key as “struts.messages.invalid.token”.

## Links
- [Struts2 Token Interceptor Example](https://www.journaldev.com/2281/struts2-token-interceptor-example)
