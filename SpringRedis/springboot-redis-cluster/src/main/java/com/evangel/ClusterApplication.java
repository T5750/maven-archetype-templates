package com.evangel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @EnableAutoConfiguration:spring boot的注解，一般只用于主类，
 * 是无xml配置启动的关键部分,明确指定了扫描包的路径为其修饰的主类的包（这也就是为什么主类要放在根包路径下的原因）
 *
 * @ComponentScan 进行包的扫描，扫描路径由@EnableAutoConfiguration指定了
 *
 * 主类要位于根包路径下，方便之后的扫描(We generally recommend that you locate your main application class in a root package above other classes.)
 */
@SpringBootApplication//same as @Configuration+@EnableAutoConfiguration+@ComponentScan
public class ClusterApplication {
	/**
	 * spring boot的入口，在整个子项目在内，
	 * 只能有一个main方法，否则spring boot启动不起来
	 */
	public static void main(String[] args) {
		SpringApplication.run(ClusterApplication.class, args);
	}
}
// http://localhost:8080/user/testJedisCluster?username=bm
