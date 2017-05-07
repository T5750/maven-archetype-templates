package quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientZookeeper {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:motan_zookeeper_client.xml");
		FooService service = (FooService) ctx.getBean("remoteService");
		System.out.println(service.hello("motan zookeeper"));
	}
}