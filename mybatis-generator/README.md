# MyBatis Generator自动生成代码
---
## Runtime Environment
 - [MyBatis Generator 1.3.5](http://www.mybatis.org/generator/index.html)
 - [Java 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
 - [IntelliJ IDEA 14.0.5](http://www.jetbrains.com/idea/download/index.html)
 - [Maven 3](http://maven.apache.org/)

## Quick Process
1. Maven Projects
2. mybatis-generator
3. Plugins
4. mybatis-generator
5. mybatis-generator:generate

## MyBatis GeneratorXML Configuration File Reference
   In the most common use case, MyBatis Generator (MBG) is driven by an XML configuration file. The configuration file tells MBG:
 - How to connect to the database
 - What objects to generate, and how to generate them
 - What tables should be used for object generation

The following is an example MBG configuration file. See the individual pages for each element for more information about the elements and the values of the attributes.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
  PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
  "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
  <classPathEntry location="/Program Files/IBM/SQLLIB/java/db2java.zip" />

  <context id="DB2Tables" targetRuntime="MyBatis3">
    <jdbcConnection driverClass="COM.ibm.db2.jdbc.app.DB2Driver"
        connectionURL="jdbc:db2:TEST"
        userId="db2admin"
        password="db2admin">
    </jdbcConnection>

    <javaTypeResolver >
      <property name="forceBigDecimals" value="false" />
    </javaTypeResolver>

    <javaModelGenerator targetPackage="test.model" targetProject="\MBGTestProject\src">
      <property name="enableSubPackages" value="true" />
      <property name="trimStrings" value="true" />
    </javaModelGenerator>

    <sqlMapGenerator targetPackage="test.xml"  targetProject="\MBGTestProject\src">
      <property name="enableSubPackages" value="true" />
    </sqlMapGenerator>

    <javaClientGenerator type="XMLMAPPER" targetPackage="test.dao"  targetProject="\MBGTestProject\src">
      <property name="enableSubPackages" value="true" />
    </javaClientGenerator>

    <table schema="DB2ADMIN" tableName="ALLTYPES" domainObjectName="Customer" >
      <property name="useActualColumnNames" value="true"/>
      <generatedKey column="ID" sqlStatement="DB2" identity="true" />
      <columnOverride column="DATE_FIELD" property="startDate" />
      <ignoreColumn column="FRED" />
      <columnOverride column="LONG_VARCHAR_FIELD" jdbcType="VARCHAR" />
    </table>

  </context>
</generatorConfiguration>
```

## Links
- [MyBatis GeneratorXML Configuration File Reference](http://www.mybatis.org/generator/configreference/xmlconfig.html)
- [MyBatis Generator介绍](http://mbg.cndocs.tk/)
- [MyBatis Generator 详解](http://blog.csdn.net/isea533/article/details/42102297)

## Copyright
Copyright 2016-2017 evangel_z.
