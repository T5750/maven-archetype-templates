package com.evangel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.evangel.model.UserInfo;

/**
 * Created by ZHR on 2016/4/27.
 */
@Controller
@RequestMapping(value = "")
public class IndexController {
	@RequestMapping(value = "")
	public ModelAndView loginView(HttpServletRequest HttpServletRequest) {
		ModelAndView mav = new ModelAndView("loginView");
		return mav;
	}

	@RequestMapping(value = "/doLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest HttpServletRequest,
			String userName, String userPwd) {
		JSONObject jsonObject = new JSONObject();
		if ("bill".equals(userName) && "123456".equals(userPwd)) {
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(1);
			userInfo.setUserName(userName);
			userInfo.setUserPwd(userPwd);
			HttpServletRequest.getSession().setAttribute("userinfo",
					JSON.toJSONString(userInfo));
			jsonObject.put("success", true);
			jsonObject.put("msg", "登录成功");
		} else {
			jsonObject.put("success", false);
			jsonObject.put("msg", "用户名或密码错误");
		}
		return jsonObject.toString();
	}

	@RequestMapping(value = "/userCenter")
	public ModelAndView userCenter(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("userCenterView");
		String userString = request.getSession().getAttribute("userinfo")
				.toString();
		UserInfo UserInfo = JSON.parseObject(userString, UserInfo.class);
		mav.addObject("user", UserInfo);
		return mav;
	}
}
