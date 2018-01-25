package com.websystique.springbatch.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.websystique.springbatch.SpringBatchJob;

@DisallowConcurrentExecution
public class SchedulerJob extends QuartzJobBean {
	private String batchJob;

	public void setBatchJob(String batchJob) {
		this.batchJob = batchJob;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) {
		ApplicationContext applicationContext = ApplicationContextUtil
				.getApplicationContext();
		SpringBatchJob job = applicationContext.getBean(batchJob,
				SpringBatchJob.class);
		System.out.println("Quartz job started: " + job);
		try {
			job.performJob();
		} catch (Exception exception) {
			System.out.println("Job " + batchJob + " could not be executed : "
					+ exception.getMessage());
		}
		System.out.println("Quartz job end");
	}
}