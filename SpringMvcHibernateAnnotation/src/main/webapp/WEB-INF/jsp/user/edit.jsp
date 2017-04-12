<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit user</title>
</head>
<body>
<c:url var="saveUrl" value="/user/save/${userAttribute.id }"/>
<%--<form:form modelAttribute="userAttribute" action="${saveUrl }">--%>
<form action="${saveUrl }" method="post">
    <table>
        <tr>
            <td>ID:</td>
            <td><input name="id" readonly="true" value="${userAttribute.id }"/></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><input name="username" value="${userAttribute.username }"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input name="password" value="${userAttribute.password }"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input name="email" value="${userAttribute.email }"/></td>
        </tr>
    </table>
    <input type="submit" value="Save">
<%--</form:form>--%>
</form>
</body>
</html>