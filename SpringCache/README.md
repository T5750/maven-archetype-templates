# SpringCache

## Runtime Environment

 - [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
 - [Spring Framework 4.3.8.RELEASE](http://projects.spring.io/spring-framework)
 - [Spring Boot 1.5.3.RELEASE](https://projects.spring.io/spring-boot)
 - [Spring MVC 4.3.8.RELEASE](http://projects.spring.io/spring-framework)
 - [Maven 3](http://maven.apache.org)

## 注释驱动的 Spring Cache

### @Cacheable、@CachePut、@CacheEvict 注释介绍

#### @Cacheable 作用和配置方法

@Cacheable 的作用：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存

----| @Cacheable 主要的参数 |----
----|------|----
value | 缓存的名称，在 spring 配置文件中定义，必须指定至少一个 | 例如：@Cacheable(value=”mycache”) 或者 @Cacheable(value={”cache1”,”cache2”}
key | 缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合 | 例如：@Cacheable(value=”testcache”,key=”#userName”)
condition | 缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存 | 例如：@Cacheable(value=”testcache”,condition=”#userName.length()>2”)

#### @CachePut 作用和配置方法

@CachePut 的作用：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用

----| @CachePut 主要的参数 |----
----|------|----
value | 缓存的名称，在 spring 配置文件中定义，必须指定至少一个 | 例如：@Cacheable(value=”mycache”) 或者 @Cacheable(value={”cache1”,”cache2”}
key | 缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合 | 例如：@Cacheable(value=”testcache”,key=”#userName”)
condition | 缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存 | 例如：@Cacheable(value=”testcache”,condition=”#userName.length()>2”)

#### @CacheEvict 作用和配置方法

@CachEvict 的作用：主要针对方法配置，能够根据一定的条件对缓存进行清空

----| @CacheEvict 主要的参数 |----
----|------|----
value | 缓存的名称，在 spring 配置文件中定义，必须指定至少一个 | 例如：@CachEvict(value=”mycache”) 或者 @CachEvict(value={”cache1”,”cache2”}
key | 缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合 | 例如：@CachEvict(value=”testcache”,key=”#userName”)
condition | 缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才清空缓存 | 例如：@CachEvict(value=”testcache”,condition=”#userName.length()>2”)
allEntries | 是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存 | 例如：@CachEvict(value=”testcache”,allEntries=true)
beforeInvocation | 是否在方法执行前就清空，缺省为 false，如果指定为 true，则在方法还没有执行的时候就清空缓存，缺省情况下，如果方法执行抛出异常，则不会清空缓存 | 例如：@CachEvict(value=”testcache”，beforeInvocation=true)

### 基本原理

和 spring 的事务管理类似，spring cache 的关键原理就是 spring AOP，通过 spring AOP，其实现了在方法调用前、调用后获取方法的入参和返回值，进而实现了缓存的逻辑。我们来看一下下面这个图：
图 2. 原始方法调用图

![图 2. 原始方法调用图](https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/image002.jpg)

上图显示，当客户端“Calling code”调用一个普通类 Plain Object 的 foo() 方法的时候，是直接作用在 pojo 类自身对象上的，客户端拥有的是被调用者的直接的引用。
而 Spring cache 利用了 Spring AOP 的动态代理技术，即当客户端尝试调用 pojo 的 foo（）方法的时候，给他的不是 pojo 自身的引用，而是一个动态生成的代理类
图 3. 动态代理调用图

![图 3. 动态代理调用图](https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/image003.jpg)

如上图所示，这个时候，实际客户端拥有的是一个代理的引用，那么在调用 foo() 方法的时候，会首先调用 proxy 的 foo() 方法，这个时候 proxy 可以整体控制实际的 pojo.foo() 方法的入参和返回值，比如缓存结果，比如直接略过执行实际的 foo() 方法等，都是可以轻松做到的。

### 注意和限制

- 基于 proxy 的 spring aop 带来的内部调用问题
- @CacheEvict 的可靠性问题
- 非 public 方法问题

## Links

- [注释驱动的 Spring cache 缓存介绍](https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/)

## Copyright

Copyright 2016-2017 evangel_z.
