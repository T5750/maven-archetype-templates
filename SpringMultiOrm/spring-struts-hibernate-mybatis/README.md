# spring-struts-hibernate-mybatis

## Runtime Environment
 - [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [Spring Framework 4.1.1.RELEASE](http://projects.spring.io/spring-framework)
 - [Struts 2 Framework 2.3.16.3](http://struts.apache.org/download.cgi#struts23163)
 - [Hibernate ORM 4.3.6.Final](http://hibernate.org/orm)
 - [MyBatis 3.2.8](http://www.mybatis.org/mybatis-3/)
 - [MySQL 5.5](http://www.mysql.com/)

## Summary
mybatis、hibernate这二个框架各有特色，对于复杂的查询，利用mybatis直接手写sql控制起来更灵活，而一般的insert/update，hibernate比较方便。同一个项目中，这二个框架可以和谐共存

## Notes
### 1.版本要求
建议：如果用hibernate 4.x ，Spring最好也是4.x系列，否则`getCurrentSession()`容易报错。

### 2.Spring配置（关键）
a) mybatis与hibernate的`sessionFactory`，共用同一个`dataSource`
b) 事务管理共用hibernate的事务管理

### 3.代码调用
3.1. 服务层基类
	其它各业务服务实现类，都继承自它。当然，也可以弄一个`BaseDAO`，对hibernate做些封装
	至于mybatis，就没必要封装了，因为各xxxMapper接口，注入后可以直接拿来调
3.2. 调用示例
	hibernate 4.x以后，entity类上的注解，最好改成@Entity("TABLE_NAME")，而非以前的@Table(xxx)，参考：`@Entity(name = "T_ORDER")`

## Tips
- `spring-struts-hibernate-mybatis\pom.xml`
    - changed java from `1.6` to `1.7`
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
