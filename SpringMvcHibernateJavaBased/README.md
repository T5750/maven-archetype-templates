# Spring 4和Hibernate 4集成教程第2部分：基于Java的配置

## Runtime Environment
- [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Java EE: Servlet 3.1, JSP 2.3, JSTL 1.2](http://www.oracle.com/technetwork/java/javaee/overview/index.html)
- [Spring framework 4.0.3.RELEASED](http://projects.spring.io/spring-framework)
- [Hibernate ORM 4.3.5.Final](http://hibernate.org/orm)
- [Maven 3](http://maven.apache.org/)
- [MySQL 5.5](http://www.mysql.com/)
- [**Tomcat 7**](http://tomcat.apache.org/)
> **NOTE**: Can not run in Tomcat 6!

## Quick Process
* 将源代码导入IDEA中
* 执行maven-archetype-templates\SpringMvcHibernateJavaBased\sql\usersdb.sql
* 部署项目，启动tomcat服务器
* web页面具体路径：http://localhost:8080/SpringMvcHibernateJavaBased
* 首页展示用户列表，可进行新增修改删除用户操作

## Simple Tutorial
1. Bootstrapping Spring Dispatcher Servlet
2. Mapping Model Class using JPA Annotations
3. Extending DAO Classes
4. Configuring Spring Application Context using Java-based Configuration
- Configuring Spring MVC View Resolvers
- Configuring DataSource Bean
- Configuring SessionFactory Bean
- Configuring TransactionManager Bean
- Configuring DAO Bean
5. Updating Spring Controller Class
6. Updating User Listing Page
7. Coding User Form Page
8. Testing the Application

## Links
- [Spring 4 and Hibernate 4 Integration Tutorial Part 2: Java-based Configuration](http://www.codejava.net/frameworks/spring/spring-4-and-hibernate-4-integration-tutorial-part-2-java-based-configuration)

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
