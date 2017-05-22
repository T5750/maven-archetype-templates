package com.evangel.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Spring Boot HelloWorldController 测试 - {@link HelloWorldController}
 *
 * Created by bysocket on 16/4/26.
 */
public class HelloWorldControllerTest {
	@Test
	public void testSayHello() {
		assertEquals("Hello,World!", new HelloWorldController().sayHello());
	}
}
