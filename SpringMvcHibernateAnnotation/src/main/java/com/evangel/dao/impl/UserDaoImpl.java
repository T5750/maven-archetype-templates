package com.evangel.dao.impl;

import org.springframework.stereotype.Repository;

import com.evangel.dao.IUserDao;
import com.evangel.dao.common.AbstractHibernateDao;
import com.evangel.model.User;

@Repository("usersDao")
public class UserDaoImpl extends AbstractHibernateDao<User> implements IUserDao {
	public UserDaoImpl() {
		super();
		setClazz(User.class);
	}
}