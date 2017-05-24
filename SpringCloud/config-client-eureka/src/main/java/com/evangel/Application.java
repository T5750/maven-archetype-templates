package com.evangel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
// http://localhost:7002/from
// Spring Cloud构建微服务架构（四）分布式配置中心（续）
// POST http://localhost:7002/refresh
// Spring Cloud构建微服务架构（七）消息总线
// RabbitMQ Management http://localhost:15672
// POST http://localhost:7002/bus/refresh
// POST http://localhost:7002/bus/refresh?destination=customers:9000
// POST http://localhost:7002/bus/refresh?destination=customers:**