package com.cnblogs.yjmyzz.dto;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("data")
public class OrderList implements Serializable {
	public OrderList() {
	}

	private static final long serialVersionUID = -7683603982464447706L;
	List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
