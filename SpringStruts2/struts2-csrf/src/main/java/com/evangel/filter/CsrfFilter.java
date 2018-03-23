package com.evangel.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.evangel.util.ConstantUtil;

public class CsrfFilter implements Filter {
	public static final String CSRF_TOKEN = "token";

	@Override
	public void destroy() {
		System.out.println("destory");
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 从 HTTP 头中取得 Referer 值
		String referer = request.getHeader("Referer");
		// 判断 Referer 是否以 bank.example 开头
		if ((referer != null)
				&& (referer.trim()
						.startsWith(ConstantUtil.getBasePath(request)))) {
			HttpSession session = request.getSession();
			// 从 session 中得到 csrftoken 属性
			String sToken = (String) session.getAttribute(CSRF_TOKEN);
			if (sToken == null) {
				// 产生新的 token 放入 session 中
				sToken = ConstantUtil.generateToken();
				session.setAttribute(CSRF_TOKEN, sToken);
				chain.doFilter(request, response);
			} else {
				// 从 HTTP 头中取得 csrftoken
				String xhrToken = request.getHeader(CSRF_TOKEN);
				// 从请求参数中取得 csrftoken
				String pToken = request.getParameter(CSRF_TOKEN);
				if (sToken != null && xhrToken != null
						&& sToken.equals(xhrToken)) {
					chain.doFilter(request, response);
				} else if (sToken != null && pToken != null
						&& sToken.equals(pToken)) {
					chain.doFilter(request, response);
				} else {
					// request.getRequestDispatcher("error.jsp").forward(request,response);
					response.sendRedirect("error");
				}
			}
		} else {
			// request.getRequestDispatcher("error.jsp").forward(request,
			// response);
			response.sendRedirect("error");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// System.out.println("init");
	}
}