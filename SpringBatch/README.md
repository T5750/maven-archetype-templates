# SpringBatch

[Spring Batch](http://docs.spring.io/spring-batch/reference/html/spring-batch-intro.html) is a lightweight, Open Source batch processing framework designed to handle the day-to-day batch processing jobs involving bulk of data. Batch processing is execution of series of job where each job may involve multiple steps.

## Spring Batch Architecture
![SpringBatch_Architecture](http://www.wailian.work/images/2018/01/23/SpringBatch_Architecture.png)

_Source : [Spring Batch Reference](http://docs.spring.io/spring-batch/reference/html/domain.html)_

A Job is composed of one to many Steps. Each Step can work in two modes :

- **Chunk Oriented Processing or READ-PROCESS-WRITE mode**: Step needs to read from a resource , process the data and then write back the process data to a resource. In this approach, Step has exactly one **ItemReader**(reader which reads from a resource, be it file, database, messaging queue etc.), **ItemProcessor** ( provides a hook to apply business logic) and **ItemWriter** (writer which writes to a resource, be it file, database, messaging queue etc).
- **TASKLET mode**: Step has to perform a single operation (be it just sending email, executing a stored procedure, cleaning up files older than x days, etc). In this approach Step includes a **Tasklet** interface which have only one method execute which can perform above mentioned activities.
A job is launched via **JobLauncher**, and **JobRepository** stores the meta data about the currently running process.Note that Steps can be chained together.

## Links
- [Spring Batch Tutorial](http://websystique.com/spring-batch-tutorial/)
- [Spring Batch Reference](http://docs.spring.io/spring-batch/reference/html/)
- [Quartz Reference Manual](http://quartz-scheduler.org/documentation)
