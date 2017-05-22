package com.evangel.dao.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.evangel.dao.UserDAO;
import com.evangel.domain.User;

public class UserDAOImpl implements UserDAO {
	@Autowired
	protected RedisTemplate<Serializable, Serializable> redisTemplate;

	public void saveUser(final User user) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(
						redisTemplate.getStringSerializer()
								.serialize("user.uid." + user.getId()),
						redisTemplate.getStringSerializer()
								.serialize(user.getName()));
				return null;
			}
		});
	}

	@Override
	public User getUser(final long id) {
		return redisTemplate.execute(new RedisCallback<User>() {
			@Override
			public User doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer()
						.serialize("user.uid." + id);
				if (connection.exists(key)) {
					byte[] value = connection.get(key);
					String name = redisTemplate.getStringSerializer()
							.deserialize(value);
					User user = new User();
					user.setName(name);
					user.setId(id);
					return user;
				}
				return null;
			}
		});
	}

	@Override
	public void delete(final long uid) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) {
				connection.del(redisTemplate.getStringSerializer()
						.serialize("user.uid." + uid));
				return null;
			}
		});
	}
}