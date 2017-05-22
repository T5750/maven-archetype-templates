package com.evangel.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evangel.dao.UserDAO;
import com.evangel.domain.User;

public class SpringDataRedisTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext.xml");
		UserDAO userDAO = (UserDAO) ac.getBean("userDAO");
		User user1 = new User();
		user1.setId(1);
		user1.setName("obama");
		userDAO.saveUser(user1);
		User user2 = userDAO.getUser(1);
		System.out.println(user2.getName());
	}
}
