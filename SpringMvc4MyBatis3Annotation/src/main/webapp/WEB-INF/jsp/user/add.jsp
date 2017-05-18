<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add User</title>
</head>
<body>
<form action="add" method="post">
    Username:<input id="username" name="username" type="text"/>
    <br>
    Password:<input id="password" name="password" type="password"/>
    <br>
    Email:<input id="email" name="email" type="text"/>
    <br>
	<input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
    <input type="submit" value="提交">
</form>
</body>
</html>