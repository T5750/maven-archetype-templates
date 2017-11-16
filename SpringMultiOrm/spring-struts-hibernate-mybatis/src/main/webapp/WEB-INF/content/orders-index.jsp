<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Orders</title> 
    <link href="${pageContext.request.contextPath}/resources/css/simplePagination/simplePagination.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/simplePagination/jquery.simplePagination.js"></script>
	<script type="text/javascript">				
		var pageIndex = ${pageIndex};
		var pageSize = ${pageSize};
		var totalPages = ${totalPages};
		var totalCounts = ${totalCounts};
		
		$(document).ready(function() {
		
			$("#page-box").pagination({
			        items: totalCounts,
			        itemsOnPage: pageSize,
			        currentPage:pageIndex,
			        cssStyle: 'light-theme',
			        prevText:'<',	
			        nextText:'>',	        
			        onPageClick:function(page){
						gotoPage(page);
					}
			});			
			showPageInfo();
			
		});
		
		function gotoPage(page) {
			window.location = "${pageContext.request.contextPath}/rest/orders/page-" + page;			
		}
		
		function showPageInfo(){
			$("#page-info").html(pageSize + "条/页，共" + totalCounts + "条，第" + pageIndex + "页，共" + totalPages + "页");
		}
	</script>   
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

	        <div class="page-header">
	            <h1>Orders:</h1>
		    </div>
            <s:actionmessage  cssClass="alert alert-error"/>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Client</th>
                    <th>Amount</th>
                    <th>CreateTime</th>
                    <th>Actions</th>
                </tr>
                <s:iterator value="model.orders">
                <tr>
                    <td>${id}</td>
                    <td><s:property value="clientName"/></td>
                    <td><s:property value="amount"/></td>
                    <td><s:date name="createTime" format="yyyy-MM-dd HH:mm:ss" /></td>
                    <td>
                        <div class="btn-group">
                            <a href="${pageContext.request.contextPath}/rest/orders/${id}" class="btn"><i class="icon icon-eye-open"></i> View</a>
                            <a href="${pageContext.request.contextPath}/rest/orders/${id}/edit" class="btn"><i class="icon icon-edit"></i> Edit</a>
                            <a href="${pageContext.request.contextPath}/rest/orders/${id}/deleteConfirm" class="btn btn-danger"><i class="icon icon-trash"></i> Delete</a>
                        </div>
                   </td>
                </tr>
                </s:iterator>
            </table>
            <a href="${pageContext.request.contextPath}/rest/orders/new" class="btn btn-primary"><i class="icon icon-file"></i> Create a new order</a>
            <table style="width:100%;margin:0 auto">
						<tr>							
							<td>
								<div id="page-box"></div>
							</td>
							<td width="40%" style="text-align:right;vertical-align:middle" id="page-info">								
							</td>
						</tr>
					</table>
        </div><!--/row-->
    </div><!--/span-->
</div><!--/row-->
</body>
</html>
	