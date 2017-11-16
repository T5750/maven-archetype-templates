package com.cnblogs.yjmyzz.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.cnblogs.yjmyzz.action.base.PageBaseAction;

@Namespace("/home")
public class HomeController extends PageBaseAction {
	private static final long serialVersionUID = 2540422725755321908L;
	private String msg;

	public String execute() {
		return "success";
	}

	@Action(value = "orders", results = { @Result(name = "orders", location = "../orders.jsp") })
	public String orders() {
		return "orders";
	}

	@Action("hello")
	public String hello() {
		return "success";
	}

	@Action("exception")
	public String showError() {
		devideZero();
		return "success";
	}

	private void devideZero() {
		int x = 1 / 0;
		System.out.println(x);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
