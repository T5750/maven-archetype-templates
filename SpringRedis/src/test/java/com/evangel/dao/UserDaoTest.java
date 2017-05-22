package com.evangel.dao;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evangel.domain.User;

public class UserDaoTest {
	private ApplicationContext app;
	private UserDAO userDao;

	@Before
	public void before() throws Exception {
		app = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext.xml");
		userDao = (UserDAO) app.getBean("userDAO");
	}

	@Test
	public void crud() {
		// -------------- Create ---------------
		long uid = 123;
		String name1 = "上海";
		User user = new User();
		user.setName(name1);
		user.setId(uid);
		userDao.saveUser(user);
		// ---------------Read ---------------
		user = userDao.getUser(uid);
		System.out.println("Name1=" + user.getName());
		assertEquals(name1, user.getName());
		// --------------Update ------------
		String name2 = "北京";
		user.setName(name2);
		userDao.saveUser(user);
		user = userDao.getUser(uid);
		System.out.println("Name2Save=" + user.getName());
		assertEquals(name2, user.getName());
		// --------------Delete ------------
		userDao.delete(uid);
		user = userDao.getUser(uid);
		// System.out.println("Namedel=" + user.getName());
		assertNull(user);
	}
}