<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Order ${id}</title>    
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

	        <div class="page-header">
		        <h1>Delete Order ${id}</h1>
	        </div>

	        <form action="../${id}?_method=DELETE" method="post">
                <p>
                    Are you sure you want to delete order ${id}?
                </p>
                <div class="btn-group">
                    <input type="submit" value="Delete" class="btn btn-danger" />
                    <input type="button" value="Cancel" class="btn btn-success" onclick="window.location.href = '../../orders'" />
                </div>
               </form>
            <br />
            <a href="${pageContext.request.contextPath}/rest/orders" class="btn btn-info">
	            <i class="icon icon-arrow-left"></i> Back to Orders
            </a>
        </div><!--/row-->
    </div><!--/span-->
</div><!--/row-->
</body>
</html>
	