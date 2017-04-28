package com.alibaba.dubbo.demo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Provider {
	public static void main(String[] args) throws Exception {
		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext(
		// new String[] {
		// "http://10.20.160.198/wiki/display/dubbo/provider.xml" });
		// context.start();
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"SpringMvcDubbo/provider/src/main/resources/provider.xml");
		System.in.read(); // 按任意键退出
	}
}
