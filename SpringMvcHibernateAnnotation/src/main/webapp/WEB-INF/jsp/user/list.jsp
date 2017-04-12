<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User List</title>
</head>
<body>
<a href="add">Add</a>
<table>
    <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Password</td>
        <td>Email</td>
    </tr>
    <c:forEach var="user" items="${userList }">
        <tr>
            <td>${user.id }</td>
            <td>${user.username }</td>
            <td>${user.password }</td>
            <td>${user.email }</td>
            <td><a href="show/${user.id }">详细</a></td>
            <td><a href="edit/${user.id }">编辑</a></td>
            <td><a href="del/${user.id }">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>