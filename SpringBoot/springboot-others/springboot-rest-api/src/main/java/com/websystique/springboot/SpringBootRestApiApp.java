package com.websystique.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.websystique.springboot" })
// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class SpringBootRestApiApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApp.class, args);
	}
}
