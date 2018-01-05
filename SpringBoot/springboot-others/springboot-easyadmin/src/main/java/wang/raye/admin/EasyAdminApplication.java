package wang.raye.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Raye
 * @since 2016年10月07日21:10:42
 */
@MapperScan(basePackages = { "wang.raye.admin.model.mapper" })
@SpringBootApplication
@ServletComponentScan
public class EasyAdminApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(EasyAdminApplication.class);
	}
}
// http://localhost:8082/admin/login
// http://localhost:8082/druid/sql.html
