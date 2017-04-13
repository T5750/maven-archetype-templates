# Spring 4和Hibernate 4集成教程第1部分：XML配置
---
## Runtime Environment

 - Java 6
 - Spring framework 4.0.3.RELEASED
 - Hibernate ORM 4.3.5.Final
 - IntelliJ IDEA 14.0.5
 - Maven 3
 - Tomcat 6

## Project Structure
![Project Structure](http://img.my.csdn.net/uploads/201704/11/1491874576_1112.png)

## Quick Process

* 将源代码导入IDEA中
* 执行maven-archetype-templates\SpringMvcHibernateXML\sql\usersdb.sql
* 部署项目，启动tomcat服务器
* web页面具体路径：http://localhost:8080/SpringMvcHibernateXML
* 点击home后，可以展示用户列表

## Simple Tutorial
1. Setting up Project
- Setting up Database
- Maven Dependencies
2. Coding Model Class Configuring Hibernate Mapping
- Writing Model Class
- Creating Hibernate XML Mapping for the Model Class
- Creating Hibernate XML Configuration File
3. Coding DAO Classes
- Writing UserDAO interface
- Writing UserDAO implementation
4. Configuring Spring Application Context
- Configuring Spring MVC View Resolvers
- Configuring DataSource Bean
- Configuring SessionFactory Bean
- Configuring TransactionManager Bean
- Configuring DAO Bean
5. Coding Controller Classes
6. Coding View Page
7. Testing the Application

## Result
![Result](http://img.my.csdn.net/uploads/201704/11/1491876303_9434.png)

## Links
- [Spring 4和Hibernate 4集成教程第1部分：XML配置](http://blog.csdn.net/evangel_z/article/details/69791766)
- [Spring 4 and Hibernate 4 Integration Tutorial Part 1: XML Configuration](http://www.codejava.net/frameworks/spring/spring-4-and-hibernate-4-integration-tutorial-part-1-xml-configuration)

### Related Tutorials:
- [Spring 4 and Struts 2 Integration Tutorial Part 1: XML Configuration](http://www.codejava.net/frameworks/spring/spring-4-and-struts-2-integration-tutorial-part-1-xml-configuration)
- [Spring 4 and Struts 2 Integration Tutorial Part 2: Java-Based and Annotations](http://www.codejava.net/frameworks/spring/spring-4-and-struts-2-integration-tutorial-part-2-java-based-and-annotations)
- [Struts 2 - Spring 4 - Hibernate 4 Integration Tutorial Part 1 - XML Configuration](http://www.codejava.net/frameworks/struts/struts-2-spring-4-hibernate-4-integration-tutorial-part-1-xml-configuration)
- [Struts 2 - Spring 4 - Hibernate 4 Integration Tutorial Part 2 - Java-Based and Annotations](http://www.codejava.net/frameworks/struts/struts-spring-hibernate-integration-tutorial-part-2-java-based-and-annotations)

### You may be also interested in:
- [Understanding the core of Spring framework](http://www.codejava.net/frameworks/spring/understanding-the-core-of-spring-framework)
- [Spring MVC beginner tutorial with Spring Tool Suite IDE](http://www.codejava.net/frameworks/spring/spring-mvc-beginner-tutorial-with-spring-tool-suite-ide)
- [Getting Started With Hibernate Annotations](http://www.codejava.net/frameworks/hibernate/getting-started-with-hibernate-annotations)

### References
- [Object Relational Mapping (ORM) Data Access](http://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/orm.html#orm-hibernate)

## Copyright

Copyright 2016-2017 evangel_z.
