package cn.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Autowired
	private TestRegistryService testRegistryService;

	@RequestMapping("/hello")
	public String index(Model model) {
		String name = testRegistryService.hello("zz");
		System.out.println("xx==" + name);
		return "";
	}
}
