package cacheOfAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainMyCache {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-cache-my.xml");// 加载 spring 配置文件
		AccountService s = (AccountService) context
				.getBean("accountServiceBean");
		System.out.println("扩展性");
		Account account = s.getAccountByName("someone");
		System.out.println("passwd=" + account.getPassword());
		account = s.getAccountByName("someone");
		System.out.println("passwd=" + account.getPassword());
	}
}
