# JerseyRESTful

## Runtime Environment
- [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Jersey 1.0.3](https://jersey.java.net/)
- [Maven 3](http://maven.apache.org/)
- [Tomcat 7](http://tomcat.apache.org/)

## RESTful Web service introduction

The most important concept in REST is resources, which are identified by global IDs— typically using URIs. Client applications use HTTP methods (GET/ POST/ PUT/ DELETE) to manipulate the resource or collection of resources. A RESTful Web service is a Web service implemented using HTTP and the principles of REST. Typically, a RESTful Web service should define the following aspects:
* The base/root URI for the Web service such as http://host/<appcontext>/resources.
* The MIME type of the response data supported, which are JSON/XML/ATOM and so on.
* The set of operations supported by the service. (for example, POST, GET, PUT or DELETE).

## JSR 311 (JAX-RS) and Jersey

Jersey is the reference implementation for JAX-RS, and it contains three major parts.
* Core Server: By providing annotations and APIs standardized in JSR 311, you can develop a RESTful Web service in a very intuitive way.
* Core Client: The Jersey client API helps you to easily communicate with REST services.
* Integration: Jersey also provides libraries that can easily integrate with Spring, Guice, Apache Abdera, and so on.

## Quick Process

* 将源代码导入IDEA中
* 部署项目，启动tomcat服务器
* web页面具体路径：http://localhost:8080/JerseyRESTful
* 运行ContactClient

## Result

```
===== Get huangyim =====
huangyim: Huang Yi Ming
===== Create foo =====
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Contact</title>
</head>
<body>
	<form action="/JerseyRESTful/rest/contacts" method="POST">
		<label for="id">ID</label>
		<input name="id" />
		<label for="name">Name</label>
		<input name="name" />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>
===== Create guoqing =====
204
===== All Contacts =====
{"contact":[{"address":[{"city":"Shanghai","street":"Long Hua Street"},{"city":"Shanghai","street":"Dong Quan Street"}],"id":"huangyim","name":"Huang Yi Ming"},{"id":"foo","name":"bar"},{"address":{"city":"Shanghai","street":"Ke Yuan Street"},"id":"guoqing","name":"Guo Qing"}]}
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><contacts><contact><address><city>Shanghai</city><street>Long Hua Street</street></address><address><city>Shanghai</city><street>Dong Quan Street</street></address><id>huangyim</id><name>Huang Yi Ming</name></contact><contact><id>foo</id><name>bar</name></contact><contact><address><city>Shanghai</city><street>Ke Yuan Street</street></address><id>guoqing</id><name>Guo Qing</name></contact></contacts>
200
[application/xml]
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><contacts><contact><address><city>Shanghai</city><street>Long Hua Street</street></address><address><city>Shanghai</city><street>Dong Quan Street</street></address><id>huangyim</id><name>Huang Yi Ming</name></contact><contact><id>foo</id><name>bar</name></contact><contact><address><city>Shanghai</city><street>Ke Yuan Street</street></address><id>guoqing</id><name>Guo Qing</name></contact></contacts>
No. of Contacts: 3
huangyim: Huang Yi Ming
===== Delete foo =====
204
===== All Contacts =====
{"contact":[{"address":[{"city":"Shanghai","street":"Long Hua Street"},{"city":"Shanghai","street":"Dong Quan Street"}],"id":"huangyim","name":"Huang Yi Ming"},{"address":{"city":"Shanghai","street":"Ke Yuan Street"},"id":"guoqing","name":"Guo Qing"}]}
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><contacts><contact><address><city>Shanghai</city><street>Long Hua Street</street></address><address><city>Shanghai</city><street>Dong Quan Street</street></address><id>huangyim</id><name>Huang Yi Ming</name></contact><contact><address><city>Shanghai</city><street>Ke Yuan Street</street></address><id>guoqing</id><name>Guo Qing</name></contact></contacts>
200
[application/xml]
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><contacts><contact><address><city>Shanghai</city><street>Long Hua Street</street></address><address><city>Shanghai</city><street>Dong Quan Street</street></address><id>huangyim</id><name>Huang Yi Ming</name></contact><contact><address><city>Shanghai</city><street>Ke Yuan Street</street></address><id>guoqing</id><name>Guo Qing</name></contact></contacts>
No. of Contacts: 2
huangyim: Huang Yi Ming
```

## Links
- [Build a RESTful Web service using Jersey and Apache Tomcat](https://www.ibm.com/developerworks/library/wa-aj-tomcat/?S_TACT=105AGX01&S_CMP=HP)
- [使用 Jersey 和 Apache Tomcat 构建 RESTful Web 服务](https://www.ibm.com/developerworks/cn/web/wa-aj-tomcat/index.html)
