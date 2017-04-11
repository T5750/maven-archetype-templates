<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
	        <h1>Users List</h1>
	        <h2><a href="new">New User</a></h2>
	        
        	<table border="1">
	        	<th>No</th>
	        	<th>Username</th>
	        	<th>Email</th>
	        	<th>Actions</th>
	        	
				<c:forEach var="user" items="${userList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>
						<a href="edit?id=${user.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?id=${user.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
