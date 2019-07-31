# Dubbo+SpringMVC工程创建详解

## Runtime Environment
- [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 3.2.8.RELEASE](http://projects.spring.io/spring-framework)
- [Dubbo 2.5.3](http://dubbo.io/)
- [ZooKeeper 3.4.10](https://zookeeper.apache.org/)
- [Maven 3](http://maven.apache.org/)
- [Tomcat 7](http://tomcat.apache.org/)

## Dubbo Architecture
![Dubbo Architecture](http://dubbo.io/images//dubbo-architecture.png)

![配置之间的关系](http://s1.wailian.download/2017/11/21/dubbo.jpg)

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
- [Dubbo Quick+Start-zh](http://dubbo.io/Quick+Start-zh.htm)
- [Dubbo 用户指南](http://dubbo.io/User+Guide-zh.htm)
- [Dubbo+SpringMVC工程创建详解（附工程文件） by tuicool](http://www.tuicool.com/articles/jiiuMrf)
- [Dubbo+SpringMVC工程创建详解（附工程文件） by AppZone](http://zoeminghong.github.io/2016/05/17/dubbo20160517/?utm_source=tuicool&utm_medium=referral)
- [Dubbo与Zookeeper、SpringMVC整合和使用（负载均衡、容错）](http://blog.csdn.net/congcong68/article/details/41113239)
