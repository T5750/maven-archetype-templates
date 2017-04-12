package com.evangel.activemq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@RequestMapping(value = "/activemq/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		System.out.println("------------welcome");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("activemq/welcome");
		return mv;
	}
}
