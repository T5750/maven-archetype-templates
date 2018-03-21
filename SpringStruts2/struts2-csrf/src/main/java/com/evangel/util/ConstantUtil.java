package com.evangel.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class ConstantUtil {
	/**
	 * @return http://localhost:8080/struts2-csrf/
	 */
	public static final String getBasePath(HttpServletRequest request) {
		// String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath()
				+ "/";
		return basePath;
	}

	public static String generateToken() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
}
