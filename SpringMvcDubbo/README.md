# Dubbo+SpringMVC工程创建详解
---
## Runtime Environment
 - [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [Spring Framework 3.2.8.RELEASE](http://projects.spring.io/spring-framework)
 - [Dubbo 2.5.3](http://dubbo.io/)
 - [ZooKeeper 3.4.10](https://zookeeper.apache.org/)
 - [IntelliJ IDEA 14.0.5](http://www.jetbrains.com/idea/download/index.html)
 - [Maven 3](http://maven.apache.org/)
 - [Tomcat 7](http://tomcat.apache.org/)

## Dubbo Architecture
![Dubbo Architecture](http://dubbo.io/dubbo-architecture.jpg-version=1&modificationDate=1330892870000.jpg)

## Project Structure
![Project Structure](http://img.my.csdn.net/uploads/201704/20/1492672291_4276.png)

## Quick Process
* ZooKeeper的配置安装
* Dubbo-admin配置安装
* Dubbo服务提供者工程创建与配置
* Dubbo服务消费者工程创建与配置
* 运行测试
1. 运行zookeeper，双击zkServer.cmd
2. 运行dubbo-admin，双击Tomcat7w.exe，点击start
3. 在IDE中用tomcat运行服务提供者，可能存在超时，配置tomcat的timeout配置就可以了
4. 在IDE中用tomcat运行服务消费者
5. 消费者工程的ConsumerServiceTest下，右键运行，就可以查看是否成功，正常结果：gege

## Links
- [Dubbo+SpringMVC工程创建详解（附工程文件）](http://www.tuicool.com/articles/jiiuMrf)
- [Dubbo+SpringMVC工程创建详解（附工程文件）](http://www.07net01.com/2016/05/1526912.html)
- [Dubbo 用户指南](http://dubbo.io/User+Guide-zh.htm)

## Copyright
Copyright 2016-2017 evangel_z.
