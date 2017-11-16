package com.cnblogs.yjmyzz.service;

import java.util.List;

import com.cnblogs.yjmyzz.dto.Order;
import com.cnblogs.yjmyzz.entity.TOrder;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface OrderService {
	public Order get(String id);

	public List<Order> getAll();

	public PageList<TOrder> getAll(int pageIndex, int pageSize)
			throws Exception;

	public void doSave(Order order);

	public void doRemove(String id);
}