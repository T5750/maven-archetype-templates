package com.weibo.motan.demo.client;

import org.springframework.stereotype.Component;

import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import com.weibo.api.motan.util.LoggerUtil;
import com.weibo.motan.demo.service.MotanDemoService;

/**
 * Created by fld on 16/6/1.
 */
@Component
public class DemoRpcHandler {
	@MotanReferer(basicReferer = "motantestClientBasicConfig", group = "motan-demo-rpc", directUrl = "127.0.0.1:8002")
	private MotanDemoService motanDemoService;

	public void test() {
		for (int i = 0; i < 10; i++) {
			System.out.println(motanDemoService.hello("motan handler" + i));
			LoggerUtil.info("motan handler" + i);
		}
	}
}
