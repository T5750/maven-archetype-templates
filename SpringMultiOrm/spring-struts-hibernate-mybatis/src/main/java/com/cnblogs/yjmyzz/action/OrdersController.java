package com.cnblogs.yjmyzz.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.cnblogs.yjmyzz.action.base.RestBaseAction;
import com.cnblogs.yjmyzz.consts.AppConsts;
import com.cnblogs.yjmyzz.convertor.OrderConverter;
import com.cnblogs.yjmyzz.dto.Order;
import com.cnblogs.yjmyzz.dto.OrderList;
import com.cnblogs.yjmyzz.entity.TOrder;
import com.cnblogs.yjmyzz.service.OrderService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.opensymphony.xwork2.Validateable;

public class OrdersController extends RestBaseAction implements Validateable {
	// /orders
	/*
	 * public String execute() { return "success"; }
	 */
	private static final long serialVersionUID = 552739094829928114L;
	Order model = new Order();
	String id;
	OrderList orders;
	@Autowired
	OrderService ordersService;

	// GET /rest/orders/1
	public HttpHeaders show() throws Exception {
		if (id != null) {
			// 如果id=x，演示拦截异常处理
			if (id.equals("x")) {
				testException();
			}
			// 分页值处理
			if (id.startsWith(AppConsts.PageParameterPrefix)) {
				int pageIndex = Integer.parseInt(id.replaceFirst(
						AppConsts.PageParameterPrefix, ""));
				return getPageData(pageIndex);
			}
			this.model = ordersService.get(id);
		}
		return new DefaultHttpHeaders("show");
	}

	// GET /orders.xhtml
	public HttpHeaders index() throws Exception {
		return getPageData(1);
	}

	// GET /rest/orders/1/edit
	public String edit() {
		if (id != null) {
			this.model = ordersService.get(id);
		}
		return "edit";
	}

	// GET /rest/orders/new
	public String editNew() {
		model = new Order();
		return "editNew";
	}

	// GET /rest/orders/1/deleteConfirm
	public String deleteConfirm() {
		if (id != null) {
			this.model = ordersService.get(id);
		}
		return "deleteConfirm";
	}

	// DELETE /rest/orders/1
	public HttpHeaders destroy() throws Exception {
		ordersService.doRemove(id);
		addActionMessage("Order removed successfully");
		return index();
	}

	// POST /orders
	public HttpHeaders create() throws IOException, ServletException {
		ordersService.doSave(model);
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String ContentType = request.getHeader("Content-Type").toLowerCase();
		if (ContentType.startsWith("application/xml")) { // 返回xml视图
			response.sendRedirect("orders/" + model.getId() + ".xml");
		} else if (ContentType.startsWith("application/json")) { // 返回json视图
			response.sendRedirect("orders/" + model.getId() + ".json");
		} else {// 返回xhtml页面视图
			response.sendRedirect("orders/");
		}
		return null;
	}

	public HttpHeaders createContinue() throws IOException, ServletException {
		return create();
	}

	// PUT /rest/orders/1
	public HttpHeaders update() throws Exception {
		ordersService.doSave(model);
		addActionMessage("Order updated successfully");
		return index();
	}

	public void validate() {
		if (model.getClientName() == null
				|| model.getClientName().length() == 0) {
			addFieldError("clientName", "The client name is empty");
		}
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getModel() {
		return (orders != null ? orders : model);
	}

	private void testException() {
		int j = 1 / 0;
		System.out.println(j);
	}

	private HttpHeaders getPageData(int pageIndex) throws Exception {
		if (orders == null) {
			orders = new OrderList();
		}
		PageList<TOrder> entities = ordersService.getAll(pageIndex,
				getPageSize());
		setPageSize(entities.getPaginator().getLimit());
		setTotalCounts(entities.getPaginator().getTotalCount());
		setTotalPages(entities.getPaginator().getTotalPages());
		setPageIndex(entities.getPaginator().getPage());
		List<Order> orderLists = new ArrayList<Order>();
		for (TOrder entity : entities) {
			orderLists.add(OrderConverter.toDto(entity));
		}
		orders.setOrders(orderLists);
		return new DefaultHttpHeaders("index").disableCaching();
	}
}
