package com.alibaba.dubbo.demo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.alibaba.bar.BarService;
import com.alibaba.dubbo.rpc.RpcContext;

//@Service(version = "1.0.0")
@Service("barService")
public class BarServiceImpl implements BarService {
	@Override
	public String findBar(String name) {
		System.out.println(
				"[" + new SimpleDateFormat("HH:mm:ss").format(new Date())
						+ "] Hello Bar " + name + ", request from consumer: "
						+ RpcContext.getContext().getRemoteAddress());
		return "Hello Bar " + name + ", response form provider: "
				+ RpcContext.getContext().getLocalAddress();
	}
}
