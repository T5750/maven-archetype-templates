package com.evangel.filter;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class DidiFilterProcessor extends FilterProcessor {
	@Override
	public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
		try {
			return super.processZuulFilter(filter);
		} catch (ZuulException e) {
			RequestContext ctx = RequestContext.getCurrentContext();
			ctx.set("failed.filter", filter);
			throw e;
		}
	}
}