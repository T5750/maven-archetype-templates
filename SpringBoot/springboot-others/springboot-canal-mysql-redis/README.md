# springboot-canal-mysql-redis

## Runtime Environment
- [Spring Framework 4.3.8.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Boot 1.5.3.RELEASE](https://projects.spring.io/spring-boot)
- [MySQL 5.6](http://www.mysql.com/)
- [Redis 3.0.7](https://redis.io)
- [canal 1.0.22](https://github.com/alibaba/canal)

## canal
- 定位： 基于数据库增量日志解析，提供增量数据订阅&消费，目前主要支持了mysql
- 关键词： mysql binlog parser / real-time / queue&topic

### mysql主备复制实现

![mysql主备复制实现](http://dl.iteye.com/upload/attachment/0080/3086/468c1a14-e7ad-3290-9d3d-44ac501a7227.jpg)

1. master将改变记录到二进制日志(binary log)中（这些记录叫做二进制日志事件，binary log events，可以通过show binlog events进行查看）；
2. slave将master的binary log events拷贝到它的中继日志(relay log)；
3. slave重做中继日志中的事件，将改变反映它自己的数据。

### canal的工作原理

![canal的工作原理](http://dl.iteye.com/upload/attachment/0080/3107/c87b67ba-394c-3086-9577-9db05be04c95.jpg)

1. canal模拟mysql slave的交互协议，伪装自己为mysql slave，向mysql master发送dump协议
2. mysql master收到dump请求，开始推送binary log给slave(也就是canal)
3. canal解析binary log对象(原始为byte流)

## Getting started
### 1.MySQL
- 目前canal测试已支持mysql 5.7.13/5.6.10及以下的版本，mariadb 5.5.35和10.0.7(理论上可支持以下版本)
- mysql-5.6.38-winx64/my.ini

	```
	[mysqld]
	log-bin=mysql-bin #添加这一行就ok
	binlog-format=ROW #选择row模式
	server_id=1 #配置mysql replaction需要定义，不能和canal的slaveId重复
	```
- canal的原理是模拟自己为mysql slave

	```
	CREATE USER canal IDENTIFIED BY 'canal';
	GRANT SELECT, REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO 'canal'@'%';
	-- GRANT ALL PRIVILEGES ON *.* TO 'canal'@'%' ;
	FLUSH PRIVILEGES;

	show grants for 'canal'
	```
### 2.canal
- [download](https://github.com/alibaba/canal/releases)
	```
	https://github.com/alibaba/canal/releases/download/canal-1.0.22/canal.deployer-1.0.22.tar.gz
	```

- canal.deployer-1.0.22/conf/example/instance.properties

	```
	vi conf/example/instance.properties

	canal.instance.mysql.slaveId = 1234

	canal.instance.master.address = 127.0.0.1:3306
	canal.instance.master.journal.name =
	canal.instance.master.position =
	canal.instance.master.timestamp =

	canal.instance.dbUsername = canal
	canal.instance.dbPassword = canal
	canal.instance.defaultDatabaseName =
	```
- 启动canal
    - linux启动 :`sh startup.sh`
    - linux带debug方式启动：(默认使用suspend=n，阻塞等待你remote debug链接成功)`sh startup.sh debug 9099`
    - linux停止：`sh stop.sh`
    - windows启动：(windows支持相对比较弱)`startup.bat`
- logs

	```
	vi logs/canal/canal.log

	vi logs/example/example.log
	```
### 3.SpringBoot
- `CanalMysqlRedisApplication`, http://localhost:8087/

## Results
![canal](http://s1.wailian.download/2018/01/03/canal.png)

## Tips
* Commits on Sep 12, 2017

## Examples
- 启动Canal Server
- `SimpleCanalClientExample`
- Simple客户端例子：`SimpleCanalClientTest`
- Cluster客户端例子：`ClusterCanalClientTest`
- `RedisCanalClient`

## Links
- [使用canal实现redis缓存刷新](https://github.com/Ac-heron/hero-canal)
- [使用canal进行mysql数据同步到Redis](http://blog.csdn.net/tb3039450/article/details/53928351)
- [QuickStart](https://github.com/alibaba/canal/wiki/QuickStart)
- [AdminGuide](https://github.com/alibaba/canal/wiki/AdminGuide)
- [SimpleCanalClientTest](https://github.com/alibaba/canal/blob/master/example/src/main/java/com/alibaba/otter/canal/example/SimpleCanalClientTest.java)
- [ClusterCanalClientTest](https://github.com/alibaba/canal/blob/master/example/src/main/java/com/alibaba/otter/canal/example/ClusterCanalClientTest.java)
