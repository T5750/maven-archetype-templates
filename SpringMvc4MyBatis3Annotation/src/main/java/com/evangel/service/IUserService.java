package com.evangel.service;

import java.util.List;

import com.evangel.domain.User;

public interface IUserService {
	public User getUserById(int userId);

	public List<User> list();

	int delete(Integer id);

	int save(User record);

	int update(User record);
}