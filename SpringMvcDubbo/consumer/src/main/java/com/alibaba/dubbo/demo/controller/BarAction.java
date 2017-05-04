package com.alibaba.dubbo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.bar.BarService;
import com.alibaba.foo.FooService;

@Controller
public class BarAction {
	// @Reference(version = "1.0.0")
	@Autowired
	private FooService fooService;
	// @Reference(version = "1.0.0")
	@Autowired
	private BarService barService;

	@RequestMapping("/helloFooBar")
	public String helloFooBar(Model model) {
		String result_foo = fooService.findFoo("Foo");
		String result_bar = barService.findBar("Bar");
		model.addAttribute("result", result_foo + "<br/>" + result_bar);
		return "result";
	}
}
