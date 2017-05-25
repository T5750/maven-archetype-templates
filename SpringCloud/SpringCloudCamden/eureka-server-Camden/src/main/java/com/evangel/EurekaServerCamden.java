package com.evangel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerCamden {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServerCamden.class).web(true)
				.run(args);
	}
}
// http://localhost:1111/
// consul agent -dev
// http://localhost:8500/