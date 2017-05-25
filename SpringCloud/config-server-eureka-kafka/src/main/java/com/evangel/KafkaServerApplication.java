package com.evangel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class KafkaServerApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(KafkaServerApplication.class).web(true)
				.run(args);
	}
}
// .\bin\windows\kafka-server-start.bat .\config\server.properties
// kafka-topics --create --zookeeper localhost:2181 --replication-factor 1
// --partitions 1 --topic test
// 启Kafka服务，64位系统不要用32位jdk！！！
// POST http://localhost:7001/bus/refresh