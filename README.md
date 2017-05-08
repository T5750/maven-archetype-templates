maven-archetype-templates
=========================

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
│       ├── edu-common-parent
│       ├── edu-demo
│       ├── edu-facade-user
│       ├── edu-service-user
│       └── edu-web-boss
└── v0.9
    └── motan-quickstart/
        ├── motan-demo-api
        ├── motan-demo-client
        └── motan-demo-server
```