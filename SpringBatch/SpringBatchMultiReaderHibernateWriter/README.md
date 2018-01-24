# SpringBatchMultiReaderHibernateWriter

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 4.0.6.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Batch 3.0.1.RELEASE](https://projects.spring.io/spring-batch/)
- [MySQL 5.6](http://www.mysql.com/)
- [Hibernate ORM 4.3.6.Final](http://hibernate.org/orm)

## Short & Quick introduction
### Create Database Table and populate it with sample data
```
create table EXAM_RESULT (
   id INT NOT NULL auto_increment PRIMARY KEY,
   student_name VARCHAR(30) NOT NULL,
   dob DATE NOT NULL,
   percentage double NOT NULL
);
```

### Prepare Input files
- `ExamResult-Year2001.txt`
- `ExamResult-Year2002.txt`
- `ExamResult-Year2003.txt`

### Create Entity Class
- `com.websystique.springbatch.model.ExamResult`

### Create Mapper to map the File fields to Entity Class
- `com.websystique.springbatch.ExamResultFieldSetMapper`

### Create an ItemProcessor
- `com.websystique.springbatch.ExamResultItemProcessor`

### Add a Job listener(JobExecutionListener)
- `com.websystique.springbatch.ExamResultJobListener`

### Create Spring Context with Hibernate SessionFactory & Spring Batch job configuration
- `src/main/resource/context-datasource.xml`
- `src/main/resource/context-model.xml`
- `src/main/resource/spring-batch-context.xml`

### Create Main application to finally run the job
- `com.websystique.springbatch.Main`

## Links
- [Spring Batch- MultiResourceItemReader & HibernateItemWriter example](http://websystique.com/springbatch/spring-batch-multiresourceitemreader-hibernateitemwriter-example/)
