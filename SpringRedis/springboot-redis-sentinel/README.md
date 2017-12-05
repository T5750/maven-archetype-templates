# springboot-redis-sentinel

## Runtime Environment
 - [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [Spring Framework 4.3.8.RELEASE](http://projects.spring.io/spring-framework)
 - [Spring Boot 1.5.3.RELEASE](https://projects.spring.io/spring-boot)
 - [Redis 3.0.7](https://redis.io)

## Getting started with Redis Sentinel
sentinel_26379.conf:
```
port 26379
daemonize yes
logfile "/var/log/sentinel_26379.log"
#master-1
sentinel monitor master-1 192.168.100.163 6379 2
sentinel down-after-milliseconds master-1 5000
sentinel failover-timeout master-1 18000
sentinel auth-pass master-1 yingjun
sentinel parallel-syncs master-1 1
```
sentinel_26380.conf:
```
port 26380
daemonize yes
logfile "/var/log/sentinel_26380.log"
#master-1
sentinel monitor master-1 192.168.100.163 6379 2
sentinel down-after-milliseconds master-1 5000
sentinel failover-timeout master-1 18000
sentinel auth-pass master-1 yingjun
sentinel parallel-syncs master-1 1
```
redis_master_6379.conf:
```
port 6379
daemonize yes
requirepass yingjun
masterauth yingjun
```
redis_slave_6380.conf:
```
port 6380
daemonize yes
requirepass yingjun
slaveof 192.168.100.163 6379
masterauth yingjun
```

terminal:
```
src/redis-server redis_master_6379.conf
src/redis-server redis_slave_6380.conf
src/redis-sentinel sentinel_26379.conf
src/redis-sentinel sentinel_26380.conf

src/redis-cli -h 192.168.100.163 -p 6379 -a yingjun
src/redis-cli -h 192.168.100.163 -p 6380 -a yingjun
src/redis-cli -h 192.168.100.163 -p 26379
src/redis-cli -h 192.168.100.163 -p 26380
```

## Links
- [Redis Sentinel主从高可用方案（附Jedis Sentinel教程）](http://wosyingjun.iteye.com/blog/2289593)
- [Redis 的 Sentinel 文档](http://www.redis.cn/topics/sentinel.html)
