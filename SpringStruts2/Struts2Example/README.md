# Struts2Example

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Struts Framework 2.3.15](http://struts.apache.org)
- [Tomcat 7](http://tomcat.apache.org/)

## Short & Quick introduction
These *Aware interfaces are:
1. `SessionAware`
1. `ApplicationAware`
1. `RequestAware`
1. `ServletRequestAware`
1. `ServletResponseAware`
1. `CookiesAware`
1. `PrincipalAware`

### Struts2 Configuration Files
- `web.xml`
- `struts.xml`

### Struts2 JSP Pages
- `login.jsp`
- `home.jsp`

### Struts2 Action Class
- `HomeAction.java`

### Results
```
Request Method: POST
Using HTTPS?: false
Request Cookies:{}
Session Attributes: {}
Context Attributes: null
Request Attributes: {struts.valueStack=com.opensymphony.xwork2.ognl.OgnlValueStack@662fe032, __cleanup_recursion_counter=1, struts.actionMapping=ActionMapping{name='home', namespace='/', method='null', extension='action', params=null, result=null}}
Request Method: POST
Using HTTPS?: false
Request Cookies:{}
Session Attributes: {test=Test, user=Pankaj}
Context Attributes: Pankaj
Request Attributes: {__cleanup_recursion_counter=1, struts.valueStack=com.opensymphony.xwork2.ognl.OgnlValueStack@749cd006, struts.actionMapping=ActionMapping{name='home', namespace='/', method='null', extension='action', params=null, result=null}}
```

## Links
- [How to get Servlet Session, Request, Response, Context Attributes in Struts 2 Action](https://www.journaldev.com/2203/get-servlet-session-request-response-context-attributes-struts-2-action)
