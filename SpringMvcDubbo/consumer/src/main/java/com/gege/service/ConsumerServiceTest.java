package com.gege.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConsumerServiceTest {
	Logger logger = Logger.getLogger(ConsumerServiceTest.class);

	public static void main(String[] args) {
		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext(
		// new String[] { "applicationContext.xml" });
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"SpringMvcDubbo/consumer/src/main/webapp/WEB-INF/applicationContext.xml");
		// context.start();
		ITestService testService = (ITestService) context
				.getBean("testService");
		System.out.println(testService.getName());
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}