package cn.test.service.impl;

import cn.test.service.TestRegistryService;
import org.springframework.stereotype.Service;

@Service("testRegistryService")
public class TestRegistryServiceImpl implements TestRegistryService {
	public String hello(String name) {
		return "hello" + name;
	}
}
