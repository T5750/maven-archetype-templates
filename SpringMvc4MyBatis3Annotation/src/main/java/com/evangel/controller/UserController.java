package com.evangel.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evangel.domain.User;
import com.evangel.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	private static final String _DIR_USER = "user/";

	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		List<User> userList = this.userService.list();
		model.addAttribute("userList", userList);
		return _DIR_USER + "list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView getAdd() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(_DIR_USER + "add");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/show/{userid}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable Integer userid) {
		User user = userService.getUserById(userid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName(_DIR_USER + "detail");
		return mv;
	}

	@RequestMapping(value = "/del/{userid}", method = RequestMethod.GET)
	public String del(@PathVariable Integer userid) {
		userService.delete(userid);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/edit/{userid}", method = RequestMethod.GET)
	public ModelAndView getEdit(@PathVariable Integer userid, Model model) {
		User user = userService.getUserById(userid);
		model.addAttribute("userAttribute", user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName(_DIR_USER + "edit");
		return mv;
	}

	@RequestMapping(value = "/save/{userid}", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("userAttribute") User user,
			@PathVariable Integer userid) {
		userService.update(user);
		return "redirect:/user/list";
	}
}