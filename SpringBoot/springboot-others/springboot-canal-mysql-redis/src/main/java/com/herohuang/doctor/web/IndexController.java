package com.herohuang.doctor.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.herohuang.doctor.dto.Canal;
import com.herohuang.doctor.util.PropertyUtil;

@Controller
public class IndexController {
	@Autowired
	private PropertyUtil propertyUtil;

	@RequestMapping(value = "/")
	public String jump(Model model) {
		List<Canal> list = propertyUtil.getCacheConfig();
		model.addAttribute("list", list);
		return "index";
	}

	@RequestMapping(value = "/toAlter")
	@ResponseBody
	public Canal alter(String tableName) {
		return new Canal(tableName,
				propertyUtil.getCacheKeyByTableName(tableName));
	}

	@RequestMapping(value = "/alter")
	public String alterpost(Canal bean) {
		propertyUtil.WriteProperties(bean.getTableName(), bean.getCacheKey());
		return "redirect:/";
	}

	@RequestMapping(value = "/add")
	public String add(Canal canal) {
		propertyUtil.WriteProperties(canal.getTableName(), canal.getCacheKey());
		return "redirect:/";
	}

	@RequestMapping(value = "/remove")
	public String remove(String tableName) {
		propertyUtil.removeProperties(tableName);
		return "redirect:/";
	}
}
