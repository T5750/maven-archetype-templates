package com.evangel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class KafkaClientApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(KafkaClientApplication.class).web(true)
				.run(args);
	}
}
// http://localhost:7002/from
// POST http://localhost:7002/bus/refresh