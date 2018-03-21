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
<title>Home Page</title>
	<%--<script src="js/token.js" type="text/javascript"></script>--%>
	<%--<script type="text/javascript">--%>
		<%--var token = "<%=session.getAttribute("token") %>";--%>
		<%--appendToken();--%>
	<%--</script>--%>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript">
		function headerToken(){
			$.ajax({
				url: "<%=path %>/referer",
				type: 'POST',
				// Fetch the stored token from localStorage and set in the header
				headers: {"token": "<%=session.getAttribute("token") %>"},
				error : function(err) {
					console.log('Error!', err)
				},
				success: function(data) {
					console.log('Success!');
					window.location.href=window.location.href;
				}
			});
		}
	</script>
</head>
<body>
<h3>Welcome to Home Page</h3>
Current token: <%=session.getAttribute("token") %>
<br/>
<a href="<%=path %>/referer?token=<%=session.getAttribute("token") %>">Goto referer by Request Parameter</a>
<br/>
<a href="<%=path %>/removeToken">Remove token</a>
<br/>
<a href="javascript:void(0)" onclick="headerToken()">Refresh token by Request Header</a>
</body>
</html>