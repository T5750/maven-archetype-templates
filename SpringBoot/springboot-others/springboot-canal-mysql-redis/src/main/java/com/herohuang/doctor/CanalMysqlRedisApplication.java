package com.herohuang.doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CanalMysqlRedisApplication {
	private static Logger logger = LoggerFactory
			.getLogger(CanalMysqlRedisApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CanalMysqlRedisApplication.class, args);
		logger.info("Application start success...");
	}
}
// http://localhost:8087/