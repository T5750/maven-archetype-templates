# SpringCache

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
- [Spring Framework 4.3.8.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Boot 1.5.3.RELEASE](https://projects.spring.io/spring-boot)
- [Spring MVC 4.3.8.RELEASE](http://projects.spring.io/spring-framework)
- [Maven 3](http://maven.apache.org)
- [Ehcache 2.6.8](http://www.ehcache.org/downloads)

## 注释驱动的 Spring Cache

### 概述

Spring 3.1 引入了激动人心的基于注释（annotation）的缓存（cache）技术，它本质上不是一个具体的缓存实现方案（例如 EHCache 或者 OSCache），而是一个对缓存使用的抽象，通过在既有代码中添加少量它定义的各种 annotation，即能够达到缓存方法的返回对象的效果。

Spring 的缓存技术还具备相当的灵活性，不仅能够使用 SpEL（Spring Expression Language）来定义缓存的 key 和各种 condition，还提供开箱即用的缓存临时存储方案，也支持和主流的专业缓存例如 EHCache 集成。

其特点总结如下：

- 通过少量的配置 annotation 注释即可使得既有代码支持缓存
- 支持开箱即用 Out-Of-The-Box，即不用安装和部署额外第三方组件即可使用缓存
- 支持 Spring Express Language，能使用对象的任何属性或者方法来定义缓存的 key 和 condition
- 支持 AspectJ，并通过其实现任何方法的缓存支持
- 支持自定义 key 和自定义缓存管理者，具有相当的灵活性和扩展性

### @Cacheable、@CachePut、@CacheEvict 注释介绍

#### @Cacheable 作用和配置方法

@Cacheable 的作用：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存

参数 | 解释 | example
----|------|----
value | 缓存的名称，在 spring 配置文件中定义，必须指定至少一个 | 例如：@Cacheable(value=”mycache”) 或者 @Cacheable(value={”cache1”,”cache2”}
key | 缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合 | 例如：@Cacheable(value=”testcache”,key=”#userName”)
condition | 缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存 | 例如：@Cacheable(value=”testcache”,condition=”#userName.length()>2”)

#### @CachePut 作用和配置方法

@CachePut 的作用：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用

参数 | 解释 | example
----|------|----
value | 缓存的名称，在 spring 配置文件中定义，必须指定至少一个 | 例如：@Cacheable(value=”mycache”) 或者 @Cacheable(value={”cache1”,”cache2”}
key | 缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合 | 例如：@Cacheable(value=”testcache”,key=”#userName”)
condition | 缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存 | 例如：@Cacheable(value=”testcache”,condition=”#userName.length()>2”)

#### @CacheEvict 作用和配置方法

@CachEvict 的作用：主要针对方法配置，能够根据一定的条件对缓存进行清空

参数 | 解释 | example
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

## 附

### @CacheConfig

@CacheConfig 的作用：@CacheConfig is a class-level annotation that allows to share the cache names，如果你在你的方法写别的名字，那么依然以方法的名字为准。

```
@CacheConfig("books")
public class BookRepositoryImpl implements BookRepository {

    @Cacheable
    public Book findBook(ISBN isbn) {...}
}
```

### 条件缓存

```
//@Cacheable将在执行方法之前( #result还拿不到返回值)判断condition，如果返回true，则查缓存；
@Cacheable(value = "user", key = "#id", condition = "#id lt 10")
public User conditionFindById(final Long id)

//@CachePut将在执行完方法后（#result就能拿到返回值了）判断condition，如果返回true，则放入缓存；
@CachePut(value = "user", key = "#id", condition = "#result.username ne 'zhang'")
public User conditionSave(final User user)

//@CachePut将在执行完方法后（#result就能拿到返回值了）判断unless，如果返回false，则放入缓存；（即跟condition相反）
@CachePut(value = "user", key = "#user.id", unless = "#result.username eq 'zhang'")
public User conditionSave2(final User user)

//@CacheEvict， beforeInvocation=false表示在方法执行之后调用（#result能拿到返回值了）；且判断condition，如果返回true，则移除缓存；
@CacheEvict(value = "user", key = "#user.id", beforeInvocation = false, condition = "#result.username ne 'zhang'")
public User conditionDelete(final User user)
```

### @Caching

```
@Caching(put = {
@CachePut(value = "user", key = "#user.id"),
@CachePut(value = "user", key = "#user.username"),
@CachePut(value = "user", key = "#user.email")
})
public User save(User user) {
```

### 自定义缓存注解

```
@Caching(put = {
@CachePut(value = "user", key = "#user.id"),
@CachePut(value = "user", key = "#user.username"),
@CachePut(value = "user", key = "#user.email")
})
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface UserSaveCache {
}
```

```
@UserSaveCache
public User save(User user)
```

### SpEL上下文数据

名称 | 位置 | 描述 | 示例
----|------|----|----
methodName | root对象 | 当前被调用的方法名 | root.methodName
method | root对象 | 当前被调用的方法 | root.method.name
target | root对象 | 当前被调用的目标对象 | root.target
targetClass | root对象 | 当前被调用的目标对象类 | root.targetClass
args | root对象 | 当前被调用的方法的参数列表 | root.args[0]
caches | root对象 | 当前方法调用使用的缓存列表（如@Cacheable(value={“cache1”, “cache2”})），则有两个cache | 	root.caches[0].name
argument name | 执行上下文 | 当前被调用的方法的参数，如findById(Long id)，我们可以通过#id拿到参数 | user.id
result | 执行上下文 | 方法执行后的返回值（仅当方法执行之后的判断有效，如‘unless’，’cache evict’的beforeInvocation=false） | result

### Guava实现

运行结果

![运行结果](http://img.blog.csdn.net/20160921154530249?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### Redis实现

运行结果

![运行结果](http://img.blog.csdn.net/20160921154539937?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## Links
- [注释驱动的 Spring cache 缓存介绍](https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/)
- [SpringBoot数据缓存Cache [Guava和Redis实现]](http://blog.csdn.net/xiaoliuliu2050/article/details/53931296)
- [Spring Cache抽象详解](http://jinnianshilongnian.iteye.com/blog/2001040)
- [Spring缓存注解@Cacheable,@CachePut , @CacheEvict使用](http://blog.csdn.net/whatlookingfor/article/details/51833378)
