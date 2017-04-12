package com.evangel.dao.common;

import java.io.Serializable;
import java.util.List;

/*
 * 通用的操作接口
 */
public interface IOperations<T extends Serializable> {
	T findOne(final long id);

	List<T> findAll();

	void create(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);
}
