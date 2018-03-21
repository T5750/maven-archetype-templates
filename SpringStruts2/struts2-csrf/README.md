# struts2-csrf

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Struts Framework 2.3.15](http://struts.apache.org)
- [Tomcat 7](http://tomcat.apache.org/)

## Short & Quick introduction
### CSRF 背景与介绍
CSRF（Cross Site Request Forgery, 跨站域请求伪造）是一种网络的攻击方式，它在 2007 年曾被列为互联网 20 大安全隐患之一。其他安全隐患，比如 SQL 脚本注入，跨站域脚本攻击等在近年来已经逐渐为众人熟知，很多网站也都针对他们进行了防御。然而，对于大多数人来说，CSRF 却依然是一个陌生的概念。即便是大名鼎鼎的 Gmail, 在 2007 年底也存在着 CSRF 漏洞，从而被黑客攻击而使 Gmail 的用户造成巨大的损失。

### 当前防御 CSRF 的几种策略
在业界目前防御 CSRF 攻击主要有三种策略：
- 验证 HTTP Referer 字段；
- 在请求地址中添加 token 并验证；
- 在 HTTP 头中自定义属性并验证。

## Links
- [CSRF 攻击的应对之道](https://www.ibm.com/developerworks/cn/web/1102_niugang_csrf/)
