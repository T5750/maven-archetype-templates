package com.gege.service.impl;

import org.springframework.stereotype.Service;

import com.gege.service.ITestService;

@Service
public class TestServiceImpl implements ITestService {
	public String getName() {
		return "gege";
	}
}