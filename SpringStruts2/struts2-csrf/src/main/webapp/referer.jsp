<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Referer Page</title>
</head>
<body>
<h3>Welcome to Referer Page</h3>
Current token: <%=session.getAttribute("token") %>
<br/>
<a href="<%=path %>/login">Goto login</a>
</body>
</html>