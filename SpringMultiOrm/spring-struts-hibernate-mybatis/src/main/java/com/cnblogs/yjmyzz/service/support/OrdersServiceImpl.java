package com.cnblogs.yjmyzz.service.support;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnblogs.yjmyzz.convertor.OrderConverter;
import com.cnblogs.yjmyzz.dao.BaseDAO;
import com.cnblogs.yjmyzz.dto.Order;
import com.cnblogs.yjmyzz.entity.TOrder;
import com.cnblogs.yjmyzz.mybatis.mapper.OrderMapper;
import com.cnblogs.yjmyzz.service.OrderService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@SuppressWarnings("all")
@Service
public class OrdersServiceImpl extends BaseServiceImpl implements OrderService {
	@Autowired
	OrderMapper orderMapper;
	@Resource
	BaseDAO<TOrder> tOrderDAO;
	private static final long serialVersionUID = 1513133416493770048L;

	@Override
	public Order get(String id) {
		// hibernate实现
		// return OrderConverter.toDto((TOrder) getCurrentSession().get(
		// TOrder.class, new BigDecimal(Integer.parseInt(id))));
		return OrderConverter.toDto(tOrderDAO.get(TOrder.class, new BigDecimal(
				Integer.parseInt(id))));
		// mybatis实现
		// return
		// OrderConverter.toDto(orderMapper.getOrder(Integer.parseInt(id)));
	}

	@Override
	public List<Order> getAll() {
		List<TOrder> entities = orderMapper.getAllOrder();
		List<Order> orders = new ArrayList<Order>();
		for (TOrder entity : entities) {
			orders.add(OrderConverter.toDto(entity));
		}
		return orders;
	}

	@Override
	public void doSave(Order order) {
		// hibernate
		TOrder entity = OrderConverter.toEntity(order);
		if (entity.getId() != null) {
			entity = (TOrder) getCurrentSession().get(TOrder.class,
					entity.getId());
			// update fields
			entity.setClientname(order.getClientName());
			entity.setAmount(new BigDecimal(order.getAmount()));
		}
		getCurrentSession().saveOrUpdate(entity);
		// 将插入成功后的值，更新到order上，以便UI上绑定时，可以反应出新值
		Order newOrder = OrderConverter.toDto(entity);
		BeanUtils.copyProperties(newOrder, order);
	}

	@Override
	public void doRemove(String id) {
		// mybatis
		orderMapper.deleteOrder(Integer.parseInt(id));
	}

	@Override
	public PageList<TOrder> getAll(int pageIndex, int pageSize)
			throws Exception {
		return (PageList<TOrder>) getPageList(OrderMapper.class, "getAllOrder",
				null, pageIndex, pageSize);
	}
}
