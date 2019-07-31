# Spring4 MVC Hibernate4集成 Annotation + ActiveMQ 整合

## Runtime Environment
- [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Java EE: Servlet 3.1, JSP 2.3, JSTL 1.2](http://www.oracle.com/technetwork/java/javaee/overview/index.html)
- [Spring framework 4.0.3.RELEASED](http://projects.spring.io/spring-framework)
- [Hibernate ORM 4.3.5.Final](http://hibernate.org/orm)
- [Maven 3](http://maven.apache.org/)
- [MySQL 5.5](http://www.mysql.com/)
- [Tomcat 7](http://tomcat.apache.org/)
- [ActiveMQ 5.5.1](http://activemq.apache.org/)

## Quick Process
* 将源代码导入IDEA中
* 执行maven-archetype-templates\SpringMvcHibernateAnnotation\sql\usersdb.sql
* 部署项目，启动tomcat服务器
* web页面具体路径：http://localhost:8080/SpringMvcHibernateAnnotation
* 在首页点击User List后展示用户列表，可进行新增修改删除用户操作
* 在首页点击Welcome to the Apache ActiveMQ!后进入欢迎界面，可进行发送接收消息
* 配置QueueMessageListener.java，负责自动监听ActiveMQ中的队列消息
> ActiveMQ管理员控制台 http://localhost:8161/admin/

## Links
- [Spring4 MVC Hibernate4集成 Annotation](http://www.cnblogs.com/leiOOlei/p/3780290.html)
- [Spring mvc4 + ActiveMQ 整合](http://www.cnblogs.com/leiOOlei/p/5075402.html)
