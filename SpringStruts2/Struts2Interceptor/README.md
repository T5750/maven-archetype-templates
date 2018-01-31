# Struts2Interceptor

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Struts Framework 2.3.15](http://struts.apache.org)

## Short & Quick introduction
Struts 2 interceptors are responsible for most of the processing done by the framework. For example, passing request params to action classes, making Servlet API request, response, session available to Action classes, validation, i18n support etc.

Struts 2 provides a bunch of interceptors and most of them are defined in `struts-default` package and used in `defaultStack` interceptor stack. Interceptors are the power of Struts 2 framework that plays a crucial role in achieving high level of separation of concerns.

### Struts 2 Interceptors and Global Results configuration
```
<global-results>
	<result name="login" type="redirect">/login.action</result>
</global-results>
```

### Struts 2 Interceptor Example
```
<package name="user" namespace="/" extends="struts-default">
	<interceptors>
		<interceptor name="authentication" class="com.journaldev.struts2.interceptors.AuthenticationInterceptor"></interceptor>
		<interceptor-stack name="authStack">
			<interceptor-ref name="authentication"></interceptor-ref>
			<interceptor-ref name="defaultStack"></interceptor-ref>
		</interceptor-stack>
	</interceptors>
	<default-interceptor-ref name="authStack"></default-interceptor-ref>
</package>
```

### Struts2 Interceptor Example Project configuration Files
- `web.xml`
- `pom.xml`
- `struts.xml`

### Result Pages
- `login.jsp`
- `welcome.jsp`

### Model Class
- `User.java`

### Custom Interceptor
- `UserAware.java`
- `AuthenticationInterceptor.java`

### Action Classes
- `LoginAction.java`
- `WelcomeAction.java`

### Results
- `http://localhost:8080/Struts2Interceptor/home.action`
- User Name: `pankaj`, Password: `admin`

![Struts2-interceptor-example-login-450x207](http://www.wailian.work/images/2018/01/31/Struts2-interceptor-example-login-450x207.png)
![Struts2-interceptor-example-success](http://www.wailian.work/images/2018/01/31/Struts2-interceptor-example-success.png)

## Links
- [Struts 2 Interceptor Example](https://www.journaldev.com/2210/struts-2-interceptor-example)
