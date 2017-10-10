package cacheOfAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPut {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-cache-anno.xml");// 加载 spring 配置文件
		AccountPutService s = (AccountPutService) context
				.getBean("accountPutServiceBean");
		System.out.println("如何做到：既要保证方法被调用，又希望结果被缓存");
		Account account = s.getAccountByName("someone");
		account.setPassword("123");
		s.updateAccount(account);
		account.setPassword("321");
		s.updateAccount(account);
		account = s.getAccountByName("someone");
		System.out.println(account.getPassword());
	}
}