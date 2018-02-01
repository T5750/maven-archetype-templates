# SpringDataJPA

## Runtime Environment
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Spring Data JPA 1.11.3.RELEASE](http://projects.spring.io/spring-data-jpa/)
- [Maven 3](http://maven.apache.org/)
- [Spring framework 4.3.8.RELEASED](http://projects.spring.io/spring-framework)
- [Hibernate ORM 4.3.5.Final](http://hibernate.org/orm)
- [MySQL 5.5](http://www.mysql.com/)

## Features

Spring 框架对 JPA 提供的支持主要体现在如下几个方面：

* 首先，它使得 JPA 配置变得更加灵活。JPA 规范要求，配置文件必须命名为 persistence.xml，并存在于类路径下的 META-INF 目录中。该文件通常包含了初始化 JPA 引擎所需的全部信息。Spring 提供的 LocalContainerEntityManagerFactoryBean 提供了非常灵活的配置，persistence.xml 中的信息都可以在此以属性注入的方式提供。
* 其次，Spring 实现了部分在 EJB 容器环境下才具有的功能，比如对 @PersistenceContext、@PersistenceUnit 的容器注入支持。
* 第三，也是最具意义的，Spring 将 EntityManager 的创建与销毁、事务管理等代码抽取出来，并由其统一管理，开发者不需要关心这些，如前面的代码所示，业务方法中只剩下操作领域对象的代码，事务管理和 EntityManager 创建、销毁的代码都不再需要开发者关心了。

使用 Spring Data JPA 进行持久层开发大致需要的三个步骤：

1. 声明持久层的接口，该接口继承 Repository，Repository 是一个标记型接口，它不包含任何方法，当然如果有需要，Spring Data 也提供了若干 Repository 子接口，其中定义了一些常用的增删改查，以及分页相关的方法。
2. 在接口中声明需要的业务方法。Spring Data 将根据给定的策略（具体策略稍后讲解）来为其生成实现代码。
3. 在 Spring 配置文件中增加一行声明，让 Spring 为声明的接口创建代理对象。配置了 <jpa:repositories> 后，Spring 初始化容器时将会扫描 base-package 指定的包目录及其子目录，为继承 Repository 或其子接口的接口创建代理对象，并将代理对象注册为 Spring Bean，业务层便可以通过 Spring 自动封装的特性来直接使用该对象。

Spring Data JPA 为此提供了一些表达条件查询的关键字，大致如下：

* And --- 等价于 SQL 中的 and 关键字，比如 findByUsernameAndPassword(String user, Striang pwd)；
* Or --- 等价于 SQL 中的 or 关键字，比如 findByUsernameOrAddress(String user, String addr)；
* Between --- 等价于 SQL 中的 between 关键字，比如 findBySalaryBetween(int max, int min)；
* LessThan --- 等价于 SQL 中的 "<"，比如 findBySalaryLessThan(int max)；
* GreaterThan --- 等价于 SQL 中的">"，比如 findBySalaryGreaterThan(int min)；
* IsNull --- 等价于 SQL 中的 "is null"，比如 findByUsernameIsNull()；
* IsNotNull --- 等价于 SQL 中的 "is not null"，比如 findByUsernameIsNotNull()；
* NotNull --- 与 IsNotNull 等价；
* Like --- 等价于 SQL 中的 "like"，比如 findByUsernameLike(String user)；
* NotLike --- 等价于 SQL 中的 "not like"，比如 findByUsernameNotLike(String user)；
* OrderBy --- 等价于 SQL 中的 "order by"，比如 findByUsernameOrderBySalaryAsc(String user)；
* Not --- 等价于 SQL 中的 "！ ="，比如 findByUsernameNot(String user)；
* In --- 等价于 SQL 中的 "in"，比如 findByUsernameIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；
* NotIn --- 等价于 SQL 中的 "not in"，比如 findByUsernameNotIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；

## Quick Process

* 将源代码导入IDEA中
* 部署项目，启动tomcat服务器
* 运行SimpleSpringJpaDemo

## Links
- [使用 Spring Data JPA 简化 JPA 开发](https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-jpa/index.html)
- [Getting started with Spring Data JPA](https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/?cm_mc_uid=79741654675514944833285&cm_mc_sid_50200000=1496379927)
