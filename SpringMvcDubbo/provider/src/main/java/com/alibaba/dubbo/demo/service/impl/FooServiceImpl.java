package com.alibaba.dubbo.demo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.foo.FooService;

//@Service(version = "1.0.0")
@Service("fooService")
public class FooServiceImpl implements FooService {
	@Override
	public String findFoo(String name) {
		System.out.println(
				"[" + new SimpleDateFormat("HH:mm:ss").format(new Date())
						+ "] Hello Foo " + name + ", request from consumer: "
						+ RpcContext.getContext().getRemoteAddress());
		return "Hello Foo " + name + ", response form provider: "
				+ RpcContext.getContext().getLocalAddress();
	}
}
