# SpringBatchDatabaseToCsv

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 4.0.6.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Batch 3.0.1.RELEASE](https://projects.spring.io/spring-batch/)
- [MySQL 5.6](http://www.mysql.com/)

## Short & Quick introduction
### Create Database Table and populate it with sample data
```
create table EXAM_RESULT (
   student_name VARCHAR(30) NOT NULL,
   dob DATE NOT NULL,
   percentage double NOT NULL
);
insert into exam_result(student_name,dob,percentage)
value('Brian Burlet','1985-02-01',76),('Rita Paul','1993-02-01',92),('Han Yenn','1965-02-01',83),('Peter Pan','1987-02-03',62);
```

### Create domain object & Mapper (RowMapper implementaion)
- `com.websystique.springbatch.model.ExamResult`
- `com.websystique.springbatch.ExamResultRowMapper`

### Create an ItemProcessor
- `com.websystique.springbatch.ExamResultItemProcessor`

### Add a Job listener(JobExecutionListener)
- `com.websystique.springbatch.ExamResultJobListener`

### Create Spring Context with job configuration
- `src/main/resource/context-datasource.xml`
- `src/main/resource/spring-batch-context.xml`

### Create Main application to finally run the job
- `com.websystique.springbatch.Main`

## Links
- [Spring Batch- Read From MySQL database & write to CSV file](http://websystique.com/springbatch/spring-batch-read-from-mysql-database-and-write-to-a-csv-file/)
