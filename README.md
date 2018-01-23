maven-archetype-templates
=========================
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/T5750/maven-archetype-templates/blob/master/LICENSE.md)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/T5750/maven-archetype-templates/pulls)
[![GitHub stars](https://img.shields.io/github/stars/T5750/maven-archetype-templates.svg?style=social&label=Stars)](https://github.com/T5750/maven-archetype-templates)
[![GitHub forks](https://img.shields.io/github/forks/T5750/maven-archetype-templates.svg?style=social&label=Fork)](https://github.com/T5750/maven-archetype-templates)

This repository contains commonly used Maven Archetype Templates.

Installation:
-------------
1. Check out the templates
2. From command line goto project root folder. For ex: C:/Apps/git/maven-archetype-templates/SpringMvcHibernateXML
3. Execute the following maven commands to install maven archetype:

    SpringMvcHibernateXML> mvn clean

    SpringMvcHibernateXML> mvn archetype:create-from-project

    SpringMvcHibernateXML> cd target/generated-sources/archetype

    SpringMvcHibernateXML/target/generated-sources/archetype> mvn clean install

4. Repeat the same steps for all the archetype templates.
5. From Your IDE, while creating maven project filter the archetypes using 'com.sivalabs' and choose the template you want.
6. Enjoy :-)

### What's included

```
maven-archetype-templates/
├── [v0.1] SpringMvcHibernateXML
├── [v0.2] SpringMvcHibernateJavaBased
├── [v0.3] SpringMvcHibernateAnnotation
├── [v0.4] SpringStrutsIntegrationDemo
├── [v0.5] Struts2Spring4Hibernate4XML
├── [v0.6] SpringMvc4MyBatis3Annotation
├── [v0.7] SpringMvcDubbo/
│    ├── api
│    ├── consumer
│    └── provider
├── [v0.8] dubbo-wusc/
│    ├── edu-common
│    ├── edu-common-config
│    ├── edu-common-core
│    ├── edu-common-parent
│    ├── edu-common-web
│    ├── edu-demo
│    ├── edu-facade-user
│    ├── edu-service-user
│    └── edu-web-boss
├── [v0.9] motan-quickstart/
│    ├── motan-demo-api
│    ├── motan-demo-client
│    └── motan-demo-server
├── [v0.10] Spring3RESTful
├── [v0.11] JerseyRESTful
├── [v0.12] SpringRedis/
│    ├── spring-data-redis
│    ├── [v0.12.1] unused-spring-data-redis
│    ├── [v0.12.2] SpringRedisMybatis
│    ├── springboot-redis-sentinel
│    └── [v0.12.3] springboot-redis-cluster
├── [v0.13] SpringBoot/
│    ├── springboot-helloworld
│    ├── springboot-restful
│    ├── springboot-freemarker
│    ├── springboot-validation-over-json
│    ├── springboot-mybatis
│    ├── springboot-mybatis-annotation
│    ├── springboot-mybatis-mutil-datasource
│    ├── springboot-mybatis-redis
│    ├── springboot-dubbo-server
│    ├── springboot-dubbo-client
│    ├── springboot-properties
│    ├── springboot-elasticsearch
│    └── springboot-others
│        ├── [v0.13.1] springboot-undertow
│        ├── [v0.13.2] springboot-swagger-druid
│        ├── [v0.13.3] springboot-canal-mysql-redis
│        ├── [v0.13.4] springboot-easyadmin
│        ├── [v0.13.5] springboot-jjwt-security
│        ├── [v0.13.6] springboot-jpa-angularjs
│        ├── [v0.13.7] springboot-jjwt-angular
│        └── [v0.13.8] springboot-rest-api
├── [v0.14] SpringCloud/
│    ├── eureka-server
│    ├── compute-service
│    ├── eureka-ribbon
│    ├── eureka-feign
│    ├── config-server
│    ├── config-client
│    ├── config-repo
│    ├── config-server-eureka
│    ├── config-client-eureka
│    ├── api-gateway
│    ├── config-server-eureka-kafka
│    ├── config-client-eureka-kafka
│    └── SpringCloudCamden
│        ├── eureka-server-Camden
│        ├── compute-service-Camden
│        ├── eureka-ribbon-Camden
│        └── eureka-feign-Camden
├── [v0.15] SpringData/
│    └── SpringDataJPA
├── [v0.16] SpringCache/
│    ├── springboot-cache
│    └── [v0.16.1] spring-cache
├── [v0.17] SpringMultiOrm/
│    └── spring-struts-hibernate-mybatis
├── [v0.18] SpringSecurity/
│    ├── SpringSecurityOAuth2
│    ├── [v0.18.1] SecureRESTApiWithBasicAuthentication
│    └── [v0.18.2] AngularClientWithBasicAuth
└── [v0.19] SpringBatch/
     └── SpringBatchCsvToXml
```