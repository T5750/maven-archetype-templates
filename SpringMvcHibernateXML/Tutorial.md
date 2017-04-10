在企业Java应用程序开发中，也许Spring和Hibernate集成是大多数程序员正在寻找和面对的最需要的主题之一。 Spring是领先的企业应用程序框架，Hibernate是领先的ORM框架，所以这两者的组合将是开发强大的企业应用程序的首选。

这是一个分步教程，可以帮助您以清晰简洁的方式轻松构建Spring-Hibernate应用程序。在第一部分中，我们演示如何编写一个简单的Spring MVC应用程序，该应用程序显示MySQL数据库中的用户列表。 DAO实现使用Hibernate的SessionFactory来查询数据库，而不是使用<a href="http://www.codejava.net/frameworks/spring/spring-mvc-with-jdbctemplate-example" target="_blank">JdbcTemplate</a>。

在演示应用中使用以下配置方法：

 - Spring MVC：controller注释和XML定义bean。
 - Hibernate：模型类的XML映射。
 - Web Application：使用 `web.xml` 部署描述符文件。

在本教程中使用以下技术和软件：

 - Java 7
 - Spring framework 4.0.3.RELEASED
 - Hibernate ORM 4.3.5.Final
 - Spring Tool Suite IDE 3.5.1
 - Maven 3
 - Tomcat 7

##1.Spring如何集成Hibernate
基本上，为了支持Hibernate集成，在`org.springframework.orm.hibernate4`包中，Spring提供了两个关键bean：

 - **LocalSessionFactoryBean**：创建一个Hibernate的**SessionFactory**，它被注入到基于Hibernate的DAO类中。
 - **HibernateTransactionManager**：为**SessionFactory**提供事务支持代码。 程序员可以在DAO方法中使用**@Transactional**注释，来避免编写明确的事务模版代码。

## 2.建立项目
让我们使用Spring Tool Suite IDE创建一个Spring MVC项目（参见例子：<a href="http://www.codejava.net/frameworks/spring/spring-mvc-beginner-tutorial-with-spring-tool-suite-ide" target="_blank">Spring MVC beginner tutorial with Spring Tool Suite IDE</a>），将其命名为**SpringMvcHibernateXML**。

###创建数据库
执行以下MySQL脚本以创建含表名为**users**的数据库**usersdb**：
``` sql
create database usersdb;
 
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1
``` 
记住要插入一些虚拟数据来进行测试。

###项目结构
以下屏幕截图显示了项目的最终结构：

![这里写图片描述](http://img.blog.csdn.net/20170410093008088?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZXZhbmdlbF96/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

**注意**：完成本教程后，您将创建一个如上所述的项目结构。

###Maven依赖关系
声明Java和Spring框架的版本：
``` xml
<properties>
    <java-version>1.7</java-version>
    <org.springframework-version>4.0.3.RELEASE</org.springframework-version>
</properties>
``` 
更新pom.xml文件以获得以下依赖关系：

 - Spring框架依赖：
``` xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
 
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-orm</artifactId>
    <version>${org.springframework-version}</version>
    <type>jar</type>
    <scope>compile</scope>
</dependency>
``` 
 - Hibernate ORM框架依赖：
``` xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>4.3.5.Final</version>
</dependency>
``` 
 - Java Servlet和JSP依赖关系（仅用于编译）：
``` xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>javax.servlet.jsp-api</artifactId>
    <version>2.3.1</version>
    <scope>provided</scope>
</dependency>
``` 
 - JSTL依赖：
``` xml
<dependency>
    <groupId>jstl</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
``` 
 - Apache Commons DBCP依赖（用于数据库连接池）：
``` xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.0</version>
</dependency>
``` 
 - MySQL Connector Java依赖（MySQL的JDBC驱动程序）：
``` xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.30</version>
</dependency>
``` 
**注意**：您可以在附件项目中查看`pom.xml`文件的全部内容。
>本书： <a href="http://www.amazon.com/gp/product/1480013978/ref=as_li_tf_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=1480013978&linkCode=as2&tag=codejava-article-20" target="_blank">Getting started with Spring Framework</a>帮助您掌握所有主要概念，如Spring核心模块，依赖注入，Spring AOP，注释驱动开发等。

##3.编写模型类并配置Hibernate映射

###编写模型类
在包`net.codejava.spring.model`中创建一个名为`User.java`的新类，其中包含以下源代码：
``` java
package net.codejava.spring.model;
 
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
 
    // getters and setters are removed for brevity
}
``` 
该模型类用于将表用户和数据库映射到普通的Java对象（POJO）。

###为模型类创建Hibernate XML映射
我们需要创建一个Hibernate XML映射文件，将`User`类映射到数据库中的`users`表。 使用以下XML代码创建与`User`类相同的包下的`User.hbm.xml`文件：
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping package="net.codejava.spring.model">
    <class name="User" table="USERS">
        <id name="id" column="USER_ID">
            <generator class="native"/>
        </id>
        <property name="username" column="USERNAME" />
        <property name="password" column="PASSWORD" />
        <property name="email" column="EMAIL" />
    </class> 
</hibernate-mapping>
``` 
**注意**：有关Hibernate XML映射的更多信息，请参阅：<a href="http://www.codejava.net/frameworks/hibernate/hibernate-one-to-many-xml-mapping-example" target="_blank">Hibernate One-to-Many XML Mapping Example</a>。

###创建Hibernate XML配置文件
在classpath的根目录（在项目的src目录下）中创建`hibernate.cfg.xml`文件，并使用以下XML代码：
``` xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>       
  <session-factory>
    <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
    <property name="show_sql">true</property> 
    <mapping resource="net/codejava/spring/model/User.hbm.xml"/>
  </session-factory>
</hibernate-configuration>
``` 
此Hibernate配置文件声明需要映射哪些资源（在本例中为`User.hbm.xml`文件）。

##4.编写DAO类

###编写UserDAO界面
为`User`类创建一个非常简单的DAO接口，如下面的`UserDAO.java`类：
``` java
package net.codejava.spring.dao;
 
import java.util.List;
import net.codejava.spring.model.User;
 
public interface UserDAO {
    public List<User> list();
}
``` 
该接口只声明一个从数据库中检索所有用户的`list()`方法。

###编写UserDAO实现
下面是我们对`UserDAO`接口的一个实现代码，`UserDAOImpl`类如下：
``` java
package net.codejava.spring.dao;
 
import java.util.List;
import net.codejava.spring.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
 
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;
 
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Override
    @Transactional
    public List<User> list() {
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listUser;
    }
}
``` 
注意在这个类中，Hibernate的`SessionFactory`对象是通过Spring的构造函数来注入的。 `list()`方法只是从`SessionFactory`获取当前会话，并查询数据库中所有用户的列表。
注意Spring提供的`@Transactional`注释 - 当一个方法被这个注释注释时，Spring会将事务支持代码注入到方法中 - 因此我们无需两次编写任何代码来明确处理事务。
>本书：<a href="http://www.amazon.com/gp/product/1935182358/ref=as_li_tf_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=1935182358&linkCode=as2&tag=code0ac-20" target="_blank">Spring in Action</a>可帮助您了解Spring MVC，REST，Security，Web Flow等最新功能，工具和实践。

##5.配置Spring应用程序上下文
现在，我们来到最重要的部分，通过一些XML配置连接Spring和Hibernate。 打开`src/main/webapp/WEB-INF/spring/appServlet`下的`servlet-context.xml`文件，并按如下所示更新其内容。
配置Spring MVC视图解析器
像往常一样，为Spring MVC注释添加以下声明驱动方法：
``` xml
<mvc:annotation-driven />
<mvc:resources mapping="/resources/**" location="/resources/" />
<context:component-scan base-package="net.codejava.spring" />
``` 
用于将逻辑视图名称转换为实际JSP页面的公共视图解析器的以下声明：
``` xml
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/views/" />
    <property name="suffix" value=".jsp" />
</bean>
``` 

###配置DataSource Bean
我们使用Apache Commons DBCP作为具有连接池功能的数据源：
``` xml
<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/usersdb"/>
    <property name="username" value="root"/>
    <property name="password" value="secret"/>
</bean>
``` 
**注意**：根据您的环境中的值更改数据库URL，用户名和密码。 该数据源将被注入到下面的`SessionFactory` bean中。

###配置SessionFactory Bean
Spring 4通过`LocalSessionFactoryBean`提供对Hibernate 4的S`essionFactory`的支持，该实例是一个`FactoryBean`，它创建一个Hibernate的`SessionFactory`，然后将其注入到基于Hibernate的DAO bean中。 这是bean声明：
``` xml
<bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
    <property name="configLocation" value="classpath:hibernate.cfg.xml" />
</bean>
``` 
请注意，此`LocalSessionFactoryBean`需要先前声明的`DataSource` bean。 `configLocation`属性指定将搜索Hibernate配置文件的位置。 在这种情况下，它是类路径中的`hibernate.cfg.xml`文件。

###配置TransactionManager Bean
以下声明用于`SessionFactory`的自动事务支持：
``` xml
<tx:annotation-driven />
<bean id="transactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">
    <property name="sessionFactory" ref="sessionFactory" />
</bean>
``` 
如`UserDAOImpl`类中所述，我们可以通过使用`@Transactional`注释来指定事务支持，用于事务感知方法。

###配置DAO Bean
最后，我们的`UserDAOImpl` bean的配置很简单：
``` xml
<bean id="userDao" class="net.codejava.spring.dao.UserDAOImpl">
    <constructor-arg>
        <ref bean="sessionFactory" />
    </constructor-arg>
</bean>
``` 
然后将该bean注入到下面描述的Spring MVC控制器类中。
**注意**：有关Spring应用程序上下文配置文件的全部内容，请参阅附件项目中的相应文件。

##6.编码控制器类
在我们的Spring MVC控制器类（`HomeController.java`）的`net.codejava.spring`包下编写以下代码：
``` java
package net.codejava.spring;
 
import java.util.List;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
    @Autowired
    private UserDAO userDao;
     
    @RequestMapping(value="/")
    public ModelAndView home() {
        List<User> listUsers = userDao.list();
        ModelAndView model = new ModelAndView("home");
        model.addObject("userList", listUsers);
        return model;
    }
}
``` 
在这里，由Spring自动注入`UserDAO`的实现（因为使用了`@Autowired`注释）。 记住我们之前在Spring应用程序上下文配置文件中声明的`UserDAOImpl` bean吗？ 它自动注入该控制器，以便处理方法`home()`可以使用它来列出数据库中的所有用户。 最后，`home()`方法返回一个名为**home**的视图，该视图解析了下面描述的一个实际的JSP页面。

##7.编写查看页面
在`src/main/webapp/WEB-INF/views`目录下创建一个`home.jsp`，具有以下内容：
``` jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Contact List</h1>
            <table border="1">
                <th>No</th>
                <th>Username</th>
                <th>Email</th>
                <c:forEach var="user" items="${userList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>       
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
``` 
该JSP页面仅显示控制器传递的用户列表，使用JSTL标记。
 
>本书：<a href="http://www.amazon.com/gp/product/1935182056/ref=as_li_tf_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=1935182056&linkCode=as2&tag=codejava-article-20" target="_blank">Spring in Practice</a>涵盖了66种Spring开发技术，可帮助您解决使用Spring框架时遇到的实际问题。

##8.测试应用程序
在Tomcat服务器上部署**SpringMvcHibernateXML**应用程序并通过以下URL访问其默认页面：

*http://localhost:8080/SpringMvcHibernateXML*

如果一切正常，您会看到以下结果：

![这里写图片描述](http://img.blog.csdn.net/20170410101620356?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZXZhbmdlbF96/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

恭喜！ 您已经完成了Spring-Hibernate Integration系列的第一部分。 您可以下载本项目的源代码并进行实践。 还提供了可部署的WAR包，方便您使用。
 
**参见第2部分**：[Spring 4 and Hibernate 4 Integration Tutorial Part 2: Java-based Configuration][1]
 
###相关教程：

 - [Spring 4 and Struts 2 Integration Tutorial Part 1: XML Configuration][2]
 - [Spring 4 and Struts 2 Integration Tutorial Part 2: Java-Based and Annotations][3]
 - [Struts 2 - Spring 4 - Hibernate 4 Integration Tutorial Part 1 - XML Configuration][4]
 - [Struts 2 - Spring 4 - Hibernate 4 Integration Tutorial Part 2 - Java-Based and Annotations][5]
 
###您可能也有兴趣：
 - [Understanding the core of Spring framework][6]
 - [Spring MVC beginner tutorial with Spring Tool Suite IDE][7]
 - [Getting Started With Hibernate Annotations][8]
 
###参考文献：
 - [Object Relational Mapping (ORM) Data Access][9]

###源代码
 - <a href="http://www.codejava.net/download-attachment?fid=315" target="_blank">SpringMvcHibernateXML.war</a>	[Deploy-read WAR]	
 - <a href="http://www.codejava.net/download-attachment?fid=314" target="_blank">SpringMvcHibernateXML.zip</a>	[Eclipse-Maven Project] 
 - <a href="https://github.com/T5750/maven-archetype-templates/tree/master/SpringMvcHibernateXML" target="_blank">SpringMvcHibernateXML</a>	[GitHub IDEA-Maven Project] 

###原文传送门
<a href="http://www.codejava.net/frameworks/spring/spring-4-and-hibernate-4-integration-tutorial-part-1-xml-configuration" target="_blank">Spring 4 and Hibernate 4 Integration Tutorial Part 1: XML Configuration</a>
[1]: http://www.codejava.net/frameworks/spring/spring-4-and-hibernate-4-integration-tutorial-part-2-java-based-configuration
[2]: http://www.codejava.net/frameworks/spring/spring-4-and-struts-2-integration-tutorial-part-1-xml-configuration
[3]: http://www.codejava.net/frameworks/spring/spring-4-and-struts-2-integration-tutorial-part-2-java-based-and-annotations
[4]: http://www.codejava.net/frameworks/struts/struts-2-spring-4-hibernate-4-integration-tutorial-part-1-xml-configuration
[5]: http://www.codejava.net/frameworks/struts/struts-spring-hibernate-integration-tutorial-part-2-java-based-and-annotations
[6]: http://www.codejava.net/frameworks/spring/understanding-the-core-of-spring-framework
[7]: http://www.codejava.net/frameworks/spring/spring-mvc-beginner-tutorial-with-spring-tool-suite-ide
[8]: http://www.codejava.net/frameworks/hibernate/getting-started-with-hibernate-annotations
[9]: http://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/orm.html#orm-hibernate
