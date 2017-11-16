package com.cnblogs.yjmyzz.action.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.cnblogs.yjmyzz.consts.AppConsts;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ValidationAwareSupport;

@ParentPackage("rest-package")
public abstract class RestBaseAction extends ValidationAwareSupport implements
		ModelDriven<Object> {
	private static final long serialVersionUID = -8773131281804917145L;

	public abstract Object getModel();

	protected Logger logger = LogManager.getLogger();
	private int pageSize = AppConsts.PageSize;
	private int pageIndex = 1;
	private int totalCounts = 0;
	private int totalPages = 0;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
