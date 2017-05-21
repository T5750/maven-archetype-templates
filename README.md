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
├── v0.1
│   └── SpringMvcHibernateXML
├── v0.2
│   └── SpringMvcHibernateJavaBased
├── v0.3
│   └── SpringMvcHibernateAnnotation
├── v0.4
│   └── SpringStrutsIntegrationDemo
├── v0.5
│   └── Struts2Spring4Hibernate4XML
├── v0.6
│   └── SpringMvc4MyBatis3Annotation
├── v0.7
│   └── SpringMvcDubbo/
│       ├── api
│       ├── consumer
│       └── provider
├── v0.8
│   └── dubbo-wusc/
│       ├── edu-common
│       ├── edu-common-config
│       ├── edu-common-core
│       ├── edu-common-parent
│       ├── edu-common-web
│       ├── edu-demo
│       ├── edu-facade-user
│       ├── edu-service-user
│       └── edu-web-boss
├── v0.9
│   └── motan-quickstart/
│       ├── motan-demo-api
│       ├── motan-demo-client
│       └── motan-demo-server
├── v0.10
│   └── Spring3RESTful
├── v0.11
│   └── JerseyRESTful
└── v0.12
    └── SpringRedis
```