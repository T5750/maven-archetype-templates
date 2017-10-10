package cacheOfAnno.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAop {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-cache-anno.xml");// 加载 spring 配置文件
		AccountService s = (AccountService) context
				.getBean("accountAopServiceBean");
		System.out.println("基于 proxy 的 spring aop 带来的内部调用问题");
		s.getAccountByName2("someone");
		s.getAccountByName2("someone");
		s.getAccountByName2("someone");
	}
}
