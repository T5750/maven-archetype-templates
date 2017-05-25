package com.evangel.filter;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ErrorExtFilter extends SendErrorFilter {
	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 30; // 大于ErrorFilter的值
	}

	@Override
	public boolean shouldFilter() {
		// 判断：仅处理来自post过滤器引起的异常
		RequestContext ctx = RequestContext.getCurrentContext();
		ZuulFilter failedFilter = (ZuulFilter) ctx.get("failed.filter");
		if (failedFilter != null && failedFilter.filterType().equals("post")) {
			return true;
		}
		return false;
	}
}