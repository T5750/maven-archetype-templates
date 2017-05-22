package com.evangel.dao;

import com.evangel.domain.User;

public interface UserDAO {
	abstract void saveUser(final User user);

	abstract User getUser(final long id);

	abstract void delete(final long id);
}
