# springboot-canal-mysql-redis

## Runtime Environment
- [Spring Framework 4.3.8.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Boot 1.5.3.RELEASE](https://projects.spring.io/spring-boot)
- [MySQL 5.6](http://www.mysql.com/)
- [Redis 3.0.7](https://redis.io)
- [canal 1.0.22](https://github.com/alibaba/canal)

## Getting started
1. mysql-5.6.38-winx64/my.ini

	```
	[mysqld]
	log-bin=mysql-bin #添加这一行就ok
	binlog-format=ROW #选择row模式
	server_id=1 #配置mysql replaction需要定义，不能和canal的slaveId重复
	```
2. canal.deployer-1.0.22/conf/example/instance.properties

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
3. 启动canal
    - linux启动 :`sh startup.sh`
    - linux带debug方式启动：(默认使用suspend=n，阻塞等待你remote debug链接成功)`sh startup.sh debug 9099`
    - linux停止：`sh stop.sh`
    - windows启动：(windows支持相对比较弱)`startup.bat`
4. logs

	```
	vi logs/canal/canal.log

	vi logs/example/example.log
	```
5. http://localhost:8087/

## Results
![canal](http://s1.wailian.download/2018/01/03/canal.png)

## Tips
* Commits on Sep 12, 2017

## Links
- [使用canal实现redis缓存刷新](https://github.com/Ac-heron/hero-canal)
- [canal-QuickStart](https://github.com/alibaba/canal/wiki/QuickStart)
- [canal-AdminGuide](https://github.com/alibaba/canal/wiki/AdminGuide)
