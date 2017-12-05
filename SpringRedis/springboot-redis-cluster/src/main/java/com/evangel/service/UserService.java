package com.evangel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evangel.domain.User;

@Service
public class UserService {
	@Autowired
	private User user;

	public User getUser() {
		return user;
	}
}