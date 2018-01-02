package wang.raye.springboot.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
@EnableTransactionManagement
/**
 * Druid的DataResource配置类
 * @author Raye
 * @since 2016年10月7日14:14:18
 */
public class DruidDataSourceConfig implements EnvironmentAware {
	private RelaxedPropertyResolver propertyResolver;

	public void setEnvironment(Environment env) {
		this.propertyResolver = new RelaxedPropertyResolver(env,
				"spring.datasource.");
	}

	@Bean
	public DataSource dataSource() {
		System.out.println("注入druid！！！");
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(propertyResolver.getProperty("url"));
		datasource.setDriverClassName(propertyResolver
				.getProperty("driver-class-name"));
		datasource.setUsername(propertyResolver.getProperty("username"));
		datasource.setPassword(propertyResolver.getProperty("password"));
		datasource.setInitialSize(Integer.valueOf(propertyResolver
				.getProperty("initial-size")));
		datasource.setMinIdle(Integer.valueOf(propertyResolver
				.getProperty("min-idle")));
		datasource.setMaxWait(Long.valueOf(propertyResolver
				.getProperty("max-wait")));
		datasource.setMaxActive(Integer.valueOf(propertyResolver
				.getProperty("max-active")));
		datasource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver
				.getProperty("min-evictable-idle-time-millis")));
		try {
			datasource.setFilters("stat,wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datasource;
	}

	/**
	 * 注册一个StatViewServlet
	 * https://github.com/alibaba/druid/issues/1370
	 * @return
	 */
	@Bean
	public ServletRegistrationBean DruidStatViewServle() {
		// org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
				new StatViewServlet(), "/druid/*");
		// 添加初始化参数：initParams
		// 白名单：
		servletRegistrationBean.addInitParameter("allow",
				"127.0.0.1,192.168.100.162,192.168.100.77");
		// IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not
		// permitted to view this page.
		servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
		// 登录查看信息的账号密码.
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		// 是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}
}
