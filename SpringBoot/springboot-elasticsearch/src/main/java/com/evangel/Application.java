package com.evangel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// 程序启动入口
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(Application.class, args);
	}
}
// POST http://127.0.0.1:8080/api/city
// {
// "id":"1",
// "provinceid":"1",
// "cityname":"温岭",
// "description":"温岭是个好城市"
// }
//
// POST http://127.0.0.1:8080/api/city
// {
// "id":"2",
// "provinceid":"2",
// "cityname":"温州",
// "description":"温州是个热城市"
// }
// http://localhost:8080/api/city/search?pageNumber=0&pageSize=10&searchContent=温岭
