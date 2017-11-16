# spring-struts-hibernate-mybatis

## Runtime Environment
 - [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [Spring Framework 4.1.1.RELEASE](http://projects.spring.io/spring-framework)
 - [Struts 2 Framework 2.3.16.3](http://struts.apache.org/download.cgi#struts23163)
 - [Hibernate ORM 4.3.6.Final](http://hibernate.org/orm)
 - [MyBatis 3.2.8](http://www.mybatis.org/mybatis-3/)
 - [MySQL 5.5](http://www.mysql.com/)

## Tips
- `spring-struts-hibernate-mybatis\pom.xml`
    - changed java from `1.6` to `1.7`
    - added mysql-connector-java.
    - changed `ojdbc6` to `mysql-connector-java`
    - changed freemarker from `2.3.19` to `2.3.20`
    - commented profiles.
- `spring-struts-hibernate-mybatis\src\main\resources\spring-datasource.xml`
    - changed `oracle.jdbc.driver.OracleDriver` to `com.mysql.jdbc.Driver`
    - changed `org.hibernate.dialect.Oracle10gDialect` to `org.hibernate.dialect.MySQLDialect`
    - changed `com.github.miemiedev.mybatis.paginator.dialect.OracleDialect` to `com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect`
- `spring-struts-hibernate-mybatis\src\main\java\com\cnblogs\yjmyzz\entity\TOrder.java`
    - changed `GenerationType.SEQUENCE` to `GenerationType.AUTO`
- `spring-struts-hibernate-mybatis\src\main\database`
    - added spring-struts-hibernate-mybatis.sql.

## Links
- [mybatis3.2.8 与 hibernate4.3.6 混用](https://www.cnblogs.com/yjmyzz/p/4047823.html)
