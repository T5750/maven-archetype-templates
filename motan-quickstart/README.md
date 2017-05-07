# Motan快速入门
---
## Runtime Environment
 - [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [Motan 0.3.0](https://github.com/weibocom/motan)
 - [Spring Framework 4.2.4.RELEASE](http://projects.spring.io/spring-framework)
 - [IntelliJ IDEA 14.0.5](http://www.jetbrains.com/idea/download/index.html)
 - [Maven 3](http://maven.apache.org/)
 - [ZooKeeper 3.4.10](https://zookeeper.apache.org/)

## Motan Architecture
Motan中分为服务提供方(RPC Server)，服务调用方(RPC Client)和服务注册中心(Registry)三个角色。

 - Server提供服务，向Registry注册自身服务，并向注册中心定期发送心跳汇报状态；
 - Client使用服务，需要向注册中心订阅RPC服务，Client根据Registry返回的服务列表，与具体的Sever建立连接，并进行RPC调用。
 - 当Server发生变更时，Registry会同步变更，Client感知后会对本地的服务列表作相应调整。

三者的交互关系如下图：

![Motan Architecture](https://github.com/weibocom/motan/wiki/media/14612349319195.jpg)

Motan框架中主要有register、transport、serialize、protocol几个功能模块，各个功能模块都支持通过SPI进行扩展，各模块的交互如下图所示：

![Motan Models](https://github.com/weibocom/motan/wiki/media/14612352579675.jpg)

## Quick Process

###简单调用示例 同步/异步调用

* 启动Server
* 启动Client或ClientMotanAsync

###集群调用示例 使用ZooKeeper作为注册中心

* 启动zkServer
* 启动ServerZookeeper
* 启动ClientZookeeper

###其他调用示例

####提供YAR协议服务

* 启动YarServerDemo
* 运行YarClient

####Api

* 启动MotanApiExportDemo
* 运行MotanApiClientDemo

## Links
- [Motan快速入门](https://github.com/weibocom/motan/wiki/zh_quickstart)
- [Motan用户指南](https://github.com/weibocom/motan/wiki/zh_userguide)
- [从motan看RPC框架设计](http://kriszhang.com/motan-rpc-impl/)

## Copyright
Copyright 2016-2017 evangel_z.
