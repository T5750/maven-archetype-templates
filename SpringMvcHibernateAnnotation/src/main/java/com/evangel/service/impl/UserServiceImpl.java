package com.evangel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.evangel.dao.IUserDao;
import com.evangel.dao.common.IOperations;
import com.evangel.model.User;
import com.evangel.service.IUserService;
import com.evangel.service.common.AbstractService;

@Service("userService")
public class UserServiceImpl extends AbstractService<User> implements IUserService {
	@Resource(name = "usersDao")
	private IUserDao dao;

	public UserServiceImpl() {
		super();
	}

	@Override
	protected IOperations<User> getDao() {
		return this.dao;
	}
}