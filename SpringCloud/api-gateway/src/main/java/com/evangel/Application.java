package com.evangel;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.evangel.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
// http://localhost:5555/api-a/add?a=1&b=2
// http://localhost:5555/api-a-url/add?a=1&b=2
// http://localhost:5555/api-b-url/add?a=1&b=2
// http://localhost:5555/api-b-url/add?a=1&b=2&accessToken=token
