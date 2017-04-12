# Spring 4和Struts 2集成教程第1部分：XML配置
---
## Runtime Environment
 - [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [Spring Framework 4.1.2.RELEASE](http://projects.spring.io/spring-framework)
 - [Struts 2 Framework 2.3.16.3](http://struts.apache.org/download.cgi#struts23163)
 - [IntelliJ IDEA 14.0.5](http://www.jetbrains.com/idea/download/index.html)
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

## Copyright
Copyright 2016-2017 evangel_z.
