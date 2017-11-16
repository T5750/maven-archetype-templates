package com.cnblogs.yjmyzz.convertor;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

import com.cnblogs.yjmyzz.dto.Order;
import com.cnblogs.yjmyzz.entity.TOrder;
import com.cnblogs.yjmyzz.util.NumberUtil;

public class OrderConverter {
	public static Order toDto(TOrder entity) {
		Order order = new Order();
		order.setAmount(NumberUtil.getIntValue(entity.getAmount()));
		order.setClientName(entity.getClientname());
		order.setCreateTime(entity.getCreatetime());
		order.setId("" + NumberUtil.getIntValue(entity.getId()));
		return order;
	}

	public static TOrder toEntity(Order dto) {
		TOrder entity = new TOrder();
		entity.setAmount(new BigDecimal(dto.getAmount()));
		entity.setClientname(dto.getClientName());
		entity.setCreatetime(dto.getCreateTime());
		if (StringUtils.isEmpty(dto.getId())) {
			entity.setId(null);
		} else {
			entity.setId(new BigDecimal(Integer.parseInt(dto.getId())));
		}
		return entity;
	}
}
