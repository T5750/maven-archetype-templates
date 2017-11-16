package com.cnblogs.yjmyzz.mybatis.mapper;

import java.util.List;

import com.cnblogs.yjmyzz.entity.TOrder;

public interface OrderMapper {
	void insertOrder(TOrder entity);

	List<TOrder> getAllOrder();

	TOrder getOrder(int id);

	void deleteOrder(int id);
}
