package com.evangel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evangel.dao.cluster.CityDao;
import com.evangel.dao.master.UserDao;
import com.evangel.domain.City;
import com.evangel.domain.User;
import com.evangel.service.UserService;

/**
 * 用户业务实现层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao; // 主数据源
	@Autowired
	private CityDao cityDao; // 从数据源

	@Override
	public User findByName(String userName) {
		User user = userDao.findByName(userName);
		City city = cityDao.findByName("温岭市");
		user.setCity(city);
		return user;
	}
}
