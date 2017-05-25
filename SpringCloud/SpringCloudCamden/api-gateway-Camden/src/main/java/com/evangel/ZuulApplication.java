package com.evangel;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.evangel.filter.AccessFilter;
import com.evangel.filter.DidiFilterProcessor;
import com.evangel.filter.ErrorFilter;
import com.netflix.zuul.FilterProcessor;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
		// Spring Cloud实战小贴士：Zuul统一异常处理（二）
		// POST http://localhost:5555/api-b-url/add?a=1
		FilterProcessor.setProcessor(new DidiFilterProcessor());
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

	// Spring Cloud实战小贴士：Zuul统一异常处理（一）
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
}
// http://localhost:5555/api-a/add?a=1&b=2
// http://localhost:5555/api-a-url/add?a=1&b=2
// http://localhost:5555/api-b-url/add?a=1&b=2
// http://localhost:5555/api-b-url/add?a=1&b=2&accessToken=token
