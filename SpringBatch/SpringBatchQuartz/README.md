# SpringBatchQuartz

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Spring Framework 4.0.6.RELEASE](http://projects.spring.io/spring-framework)
- [Spring Batch 3.0.1.RELEASE](https://projects.spring.io/spring-batch/)
- [Quartz 2.2.1](http://www.quartz-scheduler.org/)

## Short & Quick introduction
### Prepare the input flat files and corresponding domain object / mapped POJO
Below are the input files with ‘|’ separated fields which we will be putting (one or more) on each run in our input folder on file system `(E:/inputFiles)`.
- `infile.txt`
```
Shaun Pollack  |   10/03/1975  |   85
Lance Klusner  |   10/03/1972  |   98
Alan Donald    |   01/02/1973  |   76
```
- `anotherinfile.txt`
```
Brian Lara       |   09/11/1971  |   92
Malcom Marshall  |   10/03/1964  |   96
Vivian Richards  |   03/08/1960  |   88
Kurtley Ambrose  |   03/08/1971  |   61
```
- `yetanother.bak`
```
Adam Gilchrist |   09/11/1977  |   91
Steve Waugh    |   10/03/1971  |   76
Shane Warne    |   03/08/1972  |   56
Andrew Symonds |   03/08/1973  |   61
```
- `com.websystique.springbatch.model.ExamResult`

### Create a FieldSetMapper
- `com.websystique.springbatch.ExamResultFieldSetMapper`

### Create an ItemProcessor
- `com.websystique.springbatch.ExamResultItemProcessor`

### Create actual spring batch job
- `com.websystiqye.springbatch.SpringBatchJob`

### Add a Tasklet to archive file once processed
- `com.websystique.springbatch.FileArchivingTasklet`

### Add Quartz related classes
- `com.websystique.springbatch.quartz.SchedulerJob`
- `com.websystique.springbatch.quartz.ApplicationContextUtil`
- `com.websystique.springbatch.quartz.CronTriggerFactoryBean`

### Add Spring application context for Quartz and Spring Batch
- `src/main/resource/batch-context.xml`
- `src/main/resource/quartz-context.xml`

### Run Scheduler
- `com.websystique.springbatch.Main`

## Links
- [Spring Batch & Quartz Scheduler Example (Tasklet usage)](http://websystique.com/springbatch/spring-batch-quartz-scheduler-example/)
