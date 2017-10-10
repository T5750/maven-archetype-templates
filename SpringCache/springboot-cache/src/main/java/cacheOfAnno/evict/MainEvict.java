package cacheOfAnno.evict;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEvict {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-cache-anno.xml");// 加载 spring 配置文件
		AccountService s = (AccountService) context
				.getBean("accountEvictServiceBean");
		System.out.println("@CacheEvict 的可靠性问题");
		s.getAccountByName("someone");
		s.getAccountByName("someone");
		try {
			s.reload();
		} catch (Exception e) {
		}
		s.getAccountByName("someone");
		System.out.println(
				"用 @CacheEvict 注释提供的 beforeInvocation 属性，将其设置为 true，这样，在方法执行前我们的缓存就被清空了。可以确保缓存被清空。");
		s.getAccountByName("someone");
		s.getAccountByName("someone");
		try {
			s.reloadOk();
		} catch (Exception e) {
		}
		s.getAccountByName("someone");
	}
}
