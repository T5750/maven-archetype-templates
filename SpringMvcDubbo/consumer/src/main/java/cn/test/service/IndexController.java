package cn.test.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	@Autowired
	private TestRegistryService testRegistryService;

	@RequestMapping("/hello")
	public String index(
			@RequestParam(value = "zz", required = false) String zz) {
		String name;
		if (StringUtils.isNotEmpty(zz)) {
			name = testRegistryService.hello(zz);
		} else {
			name = testRegistryService.hello("zz");
		}
		System.out.println("xx==" + name);
		return "";
	}
}
