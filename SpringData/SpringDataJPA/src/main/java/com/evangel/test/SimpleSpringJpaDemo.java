package com.evangel.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evangel.service.UserService;

/**
 * Author:ZhangJianPing Time:11-9-4,下午8:57
 */
public class SimpleSpringJpaDemo {
	public static void main(String[] args) {
		// new UserServiceImpl().createNewAccount("ZhangJianPing", "123456", 1);
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-demo-cfg.xml");
		UserService userService = (UserService) ctx.getBean("userService",
				UserService.class);
		// userService.createNewAccount("g", "ggg", 700);
		// System.out.println(userService.findByBalanceGreaterThan(100,
		// new PageRequest(1, 2)));
		System.out.println(userService.findAccountInfoById(1L));
		System.out.println(userService.increaseSalary(100, 2));
	}
}
