package com.evangel.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties(prefix="user")
 * 自动读取application.properties（是spring-boot默认查找的文件）文件中的user.*的属性
 * 在没有使用@ConfigurationProperties的情况下，可以使用@Value("${user.id}")来一个个指定属性的值
 *
 * 注意：如果要使用@ConfigurationProperties和@Value，需要将该bean添加@Component，
 * 因为在后边的对该类的使用中，需要直接将该类使用@Autowire注解注入，这样这些属性的自动注入才起作用，
 * 具体使用查看"UserService"
 */
@Component
@ConfigurationProperties(prefix = "user")
public class User {
	// @Value("${user.id}")
	private int id;
	// @Value("wangna")
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}