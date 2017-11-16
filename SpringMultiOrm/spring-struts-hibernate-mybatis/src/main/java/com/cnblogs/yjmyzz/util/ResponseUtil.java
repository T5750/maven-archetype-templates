package com.cnblogs.yjmyzz.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	public static void OutputContent(HttpServletResponse response,
			String contentType, String content) throws IOException {
		response.setContentType(contentType + ";charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(content);
		out.flush();
		out.close();
	}

	public static void OutputHtml(HttpServletResponse response, String content)
			throws IOException {
		OutputContent(response, "text/html", content);
	}

	public static void OutputXml(HttpServletResponse response, String content)
			throws IOException {
		OutputContent(response, "application/xml", content);
	}

	public static void OutputJson(HttpServletResponse response, String content)
			throws IOException {
		OutputContent(response, "application/json", content);
	}
}
