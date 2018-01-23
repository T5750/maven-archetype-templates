# SpringBatchXmlToDatabase

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 4.0.6.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Batch 3.0.1.RELEASE](https://projects.spring.io/spring-batch/)
- [MySQL 5.6](http://www.mysql.com/)

## Short & Quick introduction
### Create Database Table
```
create table EXAM_RESULT (
   student_name VARCHAR(30) NOT NULL,
   dob DATE NOT NULL,
   percentage double NOT NULL
);
```

### Prepare/review the input XML file and corresponding domain object /mapped POJO
- `src/main/resources/examResult.xml`
- `com.websystique.springbatch.model.ExamResult`
- `com.websystique.springbatch.LocalDateAdapter`

### Create an ItemProcessor
- `com.websystique.springbatch.ExamResultItemProcessor`

### Add a Job listener(JobExecutionListener)
- `com.websystique.springbatch.ExamResultJobListener`

### Add a custom Converter to handle the Date conversion
- `com.websystique.springbatch.ExamResultItemPreparedStatementSetter`

### Create Spring Context with job configuration
- `src/main/resource/context-datasource.xml`
- `src/main/resource/spring-batch-context.xml`

### Create Main application to finally run the job
- `com.websystique.springbatch.Main`

## Links
- [Spring Batch- Read an XML file and write to MySQL Database](http://websystique.com/springbatch/spring-batch-read-an-xml-file-and-write-to-mysql-database/)
