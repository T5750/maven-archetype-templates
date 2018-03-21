package com.evangel.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.evangel.filter.CsrfFilter;
import com.opensymphony.xwork2.ActionSupport;

public class RefererAction extends ActionSupport {
	@Override
	public String execute() {
		return SUCCESS;
	}

	public String removeToken() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute(CsrfFilter.CSRF_TOKEN);
		return SUCCESS;
	}
}
