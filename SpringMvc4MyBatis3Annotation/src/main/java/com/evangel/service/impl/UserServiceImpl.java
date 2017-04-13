package com.evangel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.evangel.dao.UserDao;
import com.evangel.domain.User;
import com.evangel.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserDao userDao;

	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> list() {
		return this.userDao.list();
	}

	@Override
	public int delete(Integer id) {
		return this.userDao.deleteByPrimaryKey(id);
	}

	@Override
	public int save(User record) {
		return this.userDao.insertSelective(record);
	}

	@Override
	public int update(User record) {
		return this.userDao.updateByPrimaryKeySelective(record);
	}
}