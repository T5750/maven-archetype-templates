# Spring 4和Struts 2集成教程第1部分：XML配置

## Runtime Environment
- [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 4.1.2.RELEASE](http://projects.spring.io/spring-framework)
- [Struts 2 Framework 2.3.16.3](http://struts.apache.org/download.cgi#struts23163)
- [Maven 3](http://maven.apache.org/)
- [Tomcat 7](http://tomcat.apache.org/)

## Project Structure
![Project Structure](http://img.my.csdn.net/uploads/201704/12/1491982717_9230.png)

## Quick Process
* 将源代码导入IDEA中
* 部署项目，启动tomcat服务器
* web页面具体路径：http://localhost:8080/SpringStrutsIntegrationDemo
* 首页点击LoginForm进入用户登录界面

## Simple Tutorial
1. Creating Maven Project
2. Adding Maven Dependencies
3. Coding Model Class
4. Coding Business Class
5. Coding Struts Action Class
6. Coding Login Page
7. Coding Success and Error Pages
8. Configuring Spring and Struts in web.xml
9. Writing Struts Configuration
10. Writing Spring Configuration

## Result
The login form appears like in the following screenshot:
![Result](http://www.codejava.net/images/articles/frameworks/spring/spring-struts-xml/Login_Form.png)

Type “admin” for username and “nimda” for password, and then hit Enter. The success page appears:
![Result](http://www.codejava.net/images/articles/frameworks/spring/spring-struts-xml/Login_Success.png)

In case you typed wrong username/password, the error page gets displayed:
![Result](http://www.codejava.net/images/articles/frameworks/spring/spring-struts-xml/Login_Error.png)

## Links
- [Spring 4 and Struts 2 Integration Tutorial Part 1: XML Configuration](http://www.codejava.net/frameworks/spring/spring-4-and-struts-2-integration-tutorial-part-1-xml-configuration)

### Related Tutorials:
- [Spring 4 and Hibernate 4 Integration Tutorial Part 1: XML Configuration](http://www.codejava.net/frameworks/spring/spring-4-and-hibernate-4-integration-tutorial-part-1-xml-configuration)
- [Spring 4 and Hibernate 4 Integration Tutorial Part 2: Java-based Configuration](http://www.codejava.net/frameworks/spring/spring-4-and-hibernate-4-integration-tutorial-part-2-java-based-configuration)
- [Struts 2 - Spring 4 - Hibernate 4 Integration Tutorial Part 1 - XML Configuration](http://www.codejava.net/frameworks/struts/struts-2-spring-4-hibernate-4-integration-tutorial-part-1-xml-configuration)
- [Struts 2 - Spring 4 - Hibernate 4 Integration Tutorial Part 2 - Java-Based and Annotations](http://www.codejava.net/frameworks/struts/struts-spring-hibernate-integration-tutorial-part-2-java-based-and-annotations)

### You may be also interested in:
- [Understanding the core of Spring framework](http://www.codejava.net/frameworks/spring/understanding-the-core-of-spring-framework)
- [Spring MVC beginner tutorial with Spring Tool Suite IDE](http://www.codejava.net/frameworks/spring/spring-mvc-beginner-tutorial-with-spring-tool-suite-ide)
- [Introduction to Struts 2 framework](http://www.codejava.net/frameworks/struts/introduction-to-struts-2-framework)
- [Struts2 beginner tutorial (Eclipse + Tomcat + XML)](http://www.codejava.net/frameworks/struts/struts2-beginner-tutorial-eclipse-tomcat-xml)

### References
- [Struts’ Spring Plugin](https://struts.apache.org/release/2.3.x/docs/spring-plugin.html)
- [Spring: Integrating with other web frameworks](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/web-integration.html)
