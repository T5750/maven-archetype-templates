package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * @author Jonsy
 *
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAdminServer
public class AdminApplication {
	public static void main(String[] arg) {
		SpringApplication.run(AdminApplication.class);
	}
}
