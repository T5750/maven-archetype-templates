# springboot-redis-cluster

## Runtime Environment
 - [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [Spring Framework 4.3.8.RELEASE](http://projects.spring.io/spring-framework)
 - [Spring Boot 1.5.3.RELEASE](https://projects.spring.io/spring-boot)
 - [Redis 3.0.7](https://redis.io)

## Getting started with Redis Cluster
1.编译原文件
```
make
```

2.创建集群相关文件（方便管理）
```
mkdir cluster
cd cluster
mkdir 6379 6380 6381 6382 6383 6384
```

3.cluster下面每个目录中都创建一个redis.conf文件. 注意修改文件中的端口号：
```
port 6379
cluster-enabled yes
cluster-config-file nodes_6379.conf
cluster-node-timeout 5000
appendonly yes
bind 192.168.100.163
```

4.把redis-server的可执行文件复制到cluster下面的各个目录, 然后打开6个shell终端，进入各个目录，启动每个实例, 命令如下:
```
src/redis-server cluster/6379/redis.conf &
src/redis-server cluster/6380/redis.conf &
src/redis-server cluster/6381/redis.conf &
src/redis-server cluster/6382/redis.conf &
src/redis-server cluster/6383/redis.conf &
src/redis-server cluster/6384/redis.conf &
```
5.检查6个服务是否都启动了
```
ps -ef|grep redis
```

搭建集群
```
src/redis-trib.rb create --replicas 1 192.168.100.163:6379 192.168.100.163:6380 192.168.100.163:6381 192.168.100.163:6382 192.168.100.163:6383 192.168.100.163:6384
```
–replicas 1 表示我们希望为集群中的每个主节点创建一个从节点。
6.此时报错，发现缺少相应的ruby环境，如下安装相应环境：
```
yum install ruby
yum install rubygems
gem install redis
```
7.安装好环境后再次搭建集群
```
src/redis-trib.rb create --replicas 1 192.168.100.163:6379 192.168.100.163:6380 192.168.100.163:6381 192.168.100.163:6382 192.168.100.163:6383 192.168.100.163:6384
```

8.检测集群节点相关信息
```
./redis-trib.rb check 192.168.100.163:6379
```

9.进入某个节点验证
```
src/redis-cli -c -h 192.168.100.163 -p 6379
src/redis-cli -c -h 192.168.100.163 -p 6380
src/redis-cli -c -h 192.168.100.163 -p 6381
src/redis-cli -c -h 192.168.100.163 -p 6382
src/redis-cli -c -h 192.168.100.163 -p 6383
src/redis-cli -c -h 192.168.100.163 -p 6384
```

## Links
- [Redis Sentinel主从高可用方案（附Jedis Sentinel教程）](http://wosyingjun.iteye.com/blog/2289593)
- [第三章 springboot + jedisCluster](http://www.cnblogs.com/java-zhao/p/5347703.html)
- [Redis 集群教程](http://www.redis.cn/topics/cluster-tutorial.html)
