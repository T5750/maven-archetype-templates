import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.DataCache;

/**
 * 是Spring Boot项目的核心注解,主要是开启自动配置
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration
						// @ComponentScan
@RestController
// 开启缓存
@EnableCaching
@ComponentScan(basePackages = "springboot")
public class App {
	@Autowired
	private DataCache dataCache;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping("/put")
	public String put(Long id, String value) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date()) + " : value is "
				+ dataCache.put(id, value);
	}

	@RequestMapping("/get")
	public String query(Long id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date()) + " : value is " + dataCache.query(id);
	}

	@RequestMapping("/remove")
	public String remove(Long id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dataCache.remove(id);
		return sdf.format(new Date()) + " : success ";
	}
}
// http://localhost:8080/get?id=1
// http://localhost:8080/get?id=2
// http://localhost:8080/get?id=3
// http://localhost:8080/put?id=4&value=赵六
// http://localhost:8080/get?id=4
// http://localhost:8080/remove?id=2
// http://localhost:8080/get?id=2
// http://localhost:8080/put?id=2&value=%E6%9D%8E%E5%9B%9B
// http://localhost:8080/get?id=2