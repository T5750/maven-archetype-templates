package com.evangel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evangel.redis.RedisClientTemplate;

public class RedisTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:/data-source.xml");
		RedisClientTemplate redisClient = (RedisClientTemplate) ac
				.getBean("redisClientTemplate");
		final String key = "redistest";
		redisClient.setex(key, 3000, "abc");
		System.out.println(redisClient.get(key));
	}
}
