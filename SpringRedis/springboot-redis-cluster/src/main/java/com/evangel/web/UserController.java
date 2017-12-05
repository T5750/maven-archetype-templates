package com.evangel.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.evangel.common.MyConstants;
import com.evangel.domain.User;
import com.evangel.redis.MyRedisTemplate;
import com.evangel.service.UserService;

/**
 * @RestController:spring mvc的注解， 相当于@Controller与@ResponseBody的合体，可以直接返回json
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MyRedisTemplate myRedisTemplate;

	@RequestMapping("/getUser")
	public User getUser() {
		return userService.getUser();
	}

	@RequestMapping("/testJedisCluster")
	public User testJedisCluster(@RequestParam("username") String username) {
		String value = myRedisTemplate.get(
				MyConstants.USER_FORWARD_CACHE_PREFIX, username);
		if (StringUtils.isBlank(value)) {
			myRedisTemplate.set(MyConstants.USER_FORWARD_CACHE_PREFIX,
					username, JSON.toJSONString(getUser()));
			return null;
		}
		return JSON.parseObject(value, User.class);
	}
}