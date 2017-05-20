# SpringRedis

## Runtime Environment

 - [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [Spring Framework 3.1.2.RELEASE](http://projects.spring.io/spring-framework)
 - [IntelliJ IDEA 14.0.5](http://www.jetbrains.com/idea/download/index.html)
 - [Maven 3](http://maven.apache.org/)
 - [Redis](https://redis.io)

## Introducing Redis

Redis is an in-memory datastore that can also write to disk for durability. Redis can persist data in two ways: RDB and AOF. RDB persistence performs point-in-time snapshots of your data set at specified intervals. It's not very durable, and you might lose some data, but it is very fast. AOF persistence is much more durable and logs every write operation that the server receives. The write operations are reexecuted at server startup, reconstructing the original data set. When you query Redis, data is served from memory and never from disk, and Redis performs all operations on keys and values that are stored in memory.

## Getting started with Redis

The compiled binary files are now available in the src directory. Run Redis with:
* src/redis-server

To interact with Redis by using the built-in client, launch the client from the command line:
* src/redis-cli

## Redis data types by example

### Strings

```
redis> SET firstname shekhar
OK
redis> SET lastname gulati
OK
redis> GET firstname
"shekhar"
redis> GET lastname
"gulati"

redis> INCR votes
(integer) 1
redis> INCR votes
(integer) 2
redis> INCR votes
(integer) 3
redis> DECR votes
(integer) 2
```

### Lists

```
redis> LPUSH words austerity
(integer) 1
redis> LPUSH words socialism moratorium socialism socialism
(integer) 5

redis> LRANGE words 0 2
1) "socialism"
2) "socialism"
3) "moratorium"

redis > LLEN words
(integer) 5

redis> LREM words 0 socialism
(integer) 2

redis 127.0.0.1:6379> DEL words
(integer) 1
```

### Sets

```
redis> SADD uniquewords austerity
(integer) 1
redis> SADD uniquewords pragmatic
(integer) 1
redis> SADD uniquewords moratorium
(integer) 1
redis> SADD uniquewords socialism
(integer) 1
redis> SADD uniquewords socialism
(integer) 0

redis 127.0.0.1:6379> SMEMBERS uniquewords
1) "moratorium"
2) "austerity"
3) "socialism"
4) "pragmatic"

redis 127.0.0.1:6379> SADD newwords austerity good describe strange
(integer) 4

redis 127.0.0.1:6379> SINTER uniquewords newwords
1) "austerity"

redis 127.0.0.1:6379> SUNION uniquewords newwords
1) "austerity"
2) "strange"
3) "describe"
4) "socialism"
5) "pragmatic"
6) "good"
7) "moratorium"
```

### Sorted sets

```
redis> ZADD wordswithlength 9 austerity
(integer) 1
redis> ZADD wordswithlength 7 furtive
(integer) 1
redis> ZADD wordswithlength 5 bigot
(integer) 1
redis> ZRANGE wordswithlength 0 -1
1) "bigot"
2) "furtive"
3) "austerity"

redis 127.0.0.1:6379> ZCARD wordswithlength
(integer) 3
```

### Hashes

```
redis> HSET user:1 name shekhar
(integer) 1
redis> HSET user:1 lastname gulati
(integer) 1
redis> HGET user:1
redis> HGET user:1 name
"shekhar"
redis> HGETALL user:1
1) "name"
2) "shekhar"
3) "lastname"
4) "gulati"
```

## Developing a Spring Redis application

* Create a template project by using Spring Tool Suite
* Updating pom.xml with dependencies
* Configuring RedisConnectionFactory and RedisTemplate
* Writing DictionaryDao


## Links

- [Develop Spring Redis applications](https://www.ibm.com/developerworks/library/os-springredis/index.html)
- [开发 Spring Redis 应用程序](https://www.ibm.com/developerworks/cn/java/os-springredis/)

## Copyright

Copyright 2016-2017 evangel_z.
