# 基于Dubbo的分布式系统架构
---
## Runtime Environment
 - [Dubbo 2.5.3](https://github.com/alibaba/dubbo)
 - [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [Spring Framework 3.2.4.RELEASE](http://projects.spring.io/spring-framework)
 - [Struts Framework 2.3.15](http://struts.apache.org)
 - [MyBatis 3.2.2](http://www.mybatis.org/mybatis-3/)
 - [IntelliJ IDEA 14.0.5](http://www.jetbrains.com/idea/download/index.html)
 - [Maven 3](http://maven.apache.org/)
 - [Tomcat 7](http://tomcat.apache.org/)
 - [Druid 0.2.23](https://github.com/alibaba/druid)

## Quick Process
* 将源代码导入IDEA中
* 执行maven-archetype-templates\dubbo-wusc\edu-demo\sql\dubbo-wusc.sql
* 部署项目，启动tomcat服务器
* edu-demo首页路径：http://localhost:8080/edu-demo/
* edu-web-boss首页路径：http://localhost:8080/edu-web-boss/
* 首页点击用户信息管理进入用户信息管理页面，可进行添加、查看、修改、删除用户操作

> java -cp druid-0.2.23.jar com.alibaba.druid.filter.config.ConfigTools 123456

### What's included

Within the download you'll find the following directories and files, logically grouping common assets and providing both compiled and minified variations. You'll see something like this:

```
dubbo-wusc/
├── edu-common-parent/
├── edu-demo/
│   ├── sql
│   ├── src\main\java\wusc\edu\demo
│   ├── src\main\resources
│   └── src\main\webapp
├── edu-facade-user/
│   └── src\main\java\wusc\edu\facade\user
├── edu-service-user/
│   ├── src\main\java\wusc\edu
│   ├── src\main\resources
│   ├── src\main\webapp
│   └── src\test
└── edu-web-boss/
    ├── src\main\java\wusc\edu
    ├── src\main\resources
    └── src\main\webapp
```

## Result
![Result](http://img.my.csdn.net/uploads/201705/02/1493716965_2731.png)

## Notes
> Caused by: java.lang.IllegalStateException: Duplicate spring bean id pmsUserFacade

* changed pmsUserBiz to pmsUserFacade for actions in edu-web-boss

## Links
- [基于Dubbo的分布式系统架构实战](http://www.roncoo.com/course/view/85d6008fe77c4199b0cdd2885eaeee53#boxTwo)
- [安装Dubbo注册中心(Zookeeper-3.4.6)](http://www.roncoo.com/article/detail/125953)

## Copyright
Copyright 2016-2017 evangel_z.
