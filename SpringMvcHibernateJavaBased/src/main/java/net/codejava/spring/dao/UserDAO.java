package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.User;

public interface UserDAO {
	public List<User> list();

	public User get(int id);

	public void saveOrUpdate(User user);

	public void delete(int id);
}