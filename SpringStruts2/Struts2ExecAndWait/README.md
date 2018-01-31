# Struts2ExecAndWait

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Struts Framework 2.3.15](http://struts.apache.org)

## Short & Quick introduction
Struts2 provide **execAndWait** interceptor that we can use for long running action classes to return an intermediate result to user while the processing is happening at server side. Once the processing is finished, user will be presented with the final result page.

Struts2 execAndWait interceptor is already defined in the **struts-default** package and we just need to configure it for our action classes. The implementation is present in `ExecuteAndWaitInterceptor` class that returns “**wait**” result page until the processing of action class is finished.

### Project Configuration
- `web.xml`
- `pom.xml`
- `struts.xml`

### Action Class
- `ExecuteTaskAction.java`

### JSP Pages
- `run.jsp`
- `running.jsp`
- `success.jsp`

### Results
- `http://localhost:8080/Struts2ExecAndWait/run`

![Struts2-execAndWait-input](http://www.wailian.work/images/2018/01/31/Struts2-execAndWait-input.png)
![Struts2-execAndWait-wait-result](http://www.wailian.work/images/2018/01/31/Struts2-execAndWait-wait-result-450x154.png)
![Struts2-execAndWait-success](http://www.wailian.work/images/2018/01/31/Struts2-execAndWait-success-450x160.png)

## Links
- [Struts2 execAndWait interceptor example for long running Actions](https://www.journaldev.com/2296/struts2-execandwait-interceptor-example-for-long-running-actions)
