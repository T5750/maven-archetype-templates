package quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

public class ServerZookeeper {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:motan_zookeeper_server.xml");
		MotanSwitcherUtil.setSwitcherValue(
				MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
		System.out.println("server start...");
	}
}