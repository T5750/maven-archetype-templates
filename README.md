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
