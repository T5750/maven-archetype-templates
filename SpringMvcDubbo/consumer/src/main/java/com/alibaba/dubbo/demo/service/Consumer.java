package com.alibaba.dubbo.demo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.alibaba.dubbo.demo.DemoService;

public class Consumer {
	public static void main(String[] args) throws Exception {
		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext(
		// new String[] {
		// "http://10.20.160.198/wiki/display/dubbo/consumer.xml" });
		// context.start();
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"SpringMvcDubbo/consumer/src/main/resources/consumer.xml");
		DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
		String hello = demoService.sayHello("world"); // 执行远程方法
		System.out.println(hello); // 显示调用结果
	}
}