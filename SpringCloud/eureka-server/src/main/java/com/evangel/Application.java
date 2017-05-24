package com.evangel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
// http://localhost:1111/
// Spring Cloud构建微服务架构（六）高可用服务注册中心
// java -jar eureka-server-1.0-SNAPSHOT.jar --spring.profiles.active=peer1
// java -jar eureka-server-1.0-SNAPSHOT.jar --spring.profiles.active=peer2