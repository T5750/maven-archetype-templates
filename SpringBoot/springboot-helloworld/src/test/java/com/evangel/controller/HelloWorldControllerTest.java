package com.evangel.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloWorldControllerTest {
	@Test
	public void testSayHello() {
		assertEquals("Hello,World!", new HelloWorldController().sayHello());
	}
}