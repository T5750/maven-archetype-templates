# springboot-admin

## Runtime Environment
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Spring Framework 4.3.7.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Boot 1.5.2.RELEASE](https://projects.spring.io/spring-boot)
- [Spring Security 4.2.2 RELEASE](http://projects.spring.io/spring-security)
- [MySQL 5.6](http://www.mysql.com/)
- [Druid 1.0.18](https://github.com/alibaba/druid)

## Summary
基于Spring Boot/Spring Security/thymeleaf的通用后台管理系统

springboot-admin项目实现了基础的用户/菜单/角色/权限功能，可以直接基于此项目开发自己的业务管理平台。

## Getting started
- `springboot-admin.sql`
- `AdminApplication`
- [http://localhost:8080/to-login](http://localhost:8080/to-login)
- username: root, password: root

## Results
首页

![index](http://www.wailian.work/images/2018/04/18/index-min.png)

菜单管理

![menu](http://www.wailian.work/images/2018/04/18/menu-min.png)

## Tips
* Commits on Feb 24, 2017
* Modified:
    - `pom.xml`
    - `ddl.sql`
    - `Application.java`
    - `application-default.yaml`
    - `application-prod.yaml`
    - `logback.xml`
* Deleted files:
    - `resources\public\bootstrap\js`
    - `resources\public\dist\img`
    - `resources\public\plugins`

## Links
- [admin](https://github.com/jonsychen/admin)
