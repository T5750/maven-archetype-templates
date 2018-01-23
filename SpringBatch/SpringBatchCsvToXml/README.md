# SpringBatchCsvToXml

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 4.0.6.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Batch 3.0.1.RELEASE](https://projects.spring.io/spring-batch/)

## Short & Quick introduction
### Prepare the input flat file and corresponding domain object /mapped POJO
- `src/main/resources/ExamResult.txt`
- `com.websystique.springbatch.model.ExamResult`
- `com.websystique.springbatch.LocalDateAdapter`

### Create a FieldSetMapper
- `com.websystique.springbatch.ExamResultFieldSetMapper`

### Create an ItemProcessor
- `com.websystique.springbatch.ExamResultItemProcessor`

### Add a Job listener(JobExecutionListener)
- `com.websystique.springbatch.ExamResultJobListener`

### Create Spring Context with job configuration
- `src/main/resource/spring-batch-context.xml`

### Create Main application to finally run the job
- `com.websystique.springbatch.Main`

## Links
- [Spring Batch- Read a CSV file and write to an XML file](http://websystique.com/springbatch/spring-batch-read-a-csv-file-and-write-to-an-xml-file/)
