package com.websystique.springbatch;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;

public class SpringBatchJob {
	private String jobName;
	private JobLocator jobLocator;
	private JobLauncher jobLauncher;
	private File contentDirectory;
	private String directoryPath = "E:/inputFiles";

	public void init() {
		contentDirectory = new File(directoryPath);
	}

	boolean fileFound = false;

	public void performJob() {
		System.out.println("Starting ExamResult Job");
		try {
			if (contentDirectory == null || !contentDirectory.isDirectory()) {
				System.err
						.println("Input directory doesn't exist. Job ExamResult terminated");
			}
			fileFound = false;
			for (File file : contentDirectory.listFiles()) {
				if (file.isFile()) {
					System.out.println("File found :" + file.getAbsolutePath());
					fileFound = true;
					JobParameter param = new JobParameter(
							file.getAbsolutePath());
					Map<String, JobParameter> map = new HashMap<String, JobParameter>();
					map.put("examResultInputFile", param);
					map.put("date", new JobParameter(new Date()));
					JobExecution result = jobLauncher.run(
							jobLocator.getJob(jobName), new JobParameters(map));
					System.out.println("ExamResult Job completetion details : "
							+ result.toString());
				}
			}
			if (!fileFound) {
				System.out.println("No Input file found, Job terminated.");
			}
		} catch (JobExecutionException ex) {
			System.out
					.println("ExamResult Job halted with following excpetion :"
							+ ex);
		}
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}
}
