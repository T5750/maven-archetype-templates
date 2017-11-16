<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RESTful && No RESTful</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jquery-1.7.1.min.js"></script>
<style type="text/css">
li {
	line-height: 150%;
	font-size: 18px;
	
}

a {
	text-decoration: none
}

a:hover {
	text-decoration: under-line;
	color:red;
}
</style>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/config-browser" target="_blank">config-browser</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="${pageContext.request.contextPath}/no-action" target="_blank">no-action</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="${pageContext.request.contextPath}/home" target="_blank">home</a></li>
		<li><a href="${pageContext.request.contextPath}/home/hello?msg=jimmy.yang" target="_blank">home/hello</a></li>
		<li><a href="${pageContext.request.contextPath}/home/exception" target="_blank">home/exception</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="${pageContext.request.contextPath}/rest/orders" target="_blank">rest/orders</a></li>
		<li><a href="${pageContext.request.contextPath}/rest/orders.xml" target="_blank">rest/orders.xml</a></li>
		<li><a href="${pageContext.request.contextPath}/rest/orders.json" target="_blank">rest/orders.json</a></li>
		<li><a href="${pageContext.request.contextPath}/rest/orders/x" target="_blank">rest/orders/x</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="#" onclick="getList()">ajax/get-list-json</a></li>
		<li><a href="#" onclick="getModel()">ajax/get-model-json</a></li>
		<li><a href="#" onclick="postModel()">ajax/post-model-json</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="#" onclick="getListXml()">ajax/get-list-xml</a></li>
		<li><a href="#" onclick="getModelXml()">ajax/get-model-xml</a></li>
		<li><a href="#" onclick="postModelXml()">ajax/post-model-xml</a></li>
	</ul>
	<script type="text/javascript">

		
		function getList(){           
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/rest/orders.json",               
                success: function(data, textStatus, jqXHR){
                    alert("以下是从服务器返回的对象:\n\n" + data + "\n\n" + data.orders.length + "条记录\n id[0]:" + data.orders[0].id+ "\n createTime[0]:" + (new Date(data.orders[0].createTime)).toLocaleDateString());
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
        function getListXml(){           
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/rest/orders.xml",               
                success: function(data, textStatus, jqXHR){
                    alert("以下是从服务器返回的结果:\n\n" + data.documentElement.outerHTML );
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
        function getModel(){           
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/rest/orders/4.json",               
                success: function(data, textStatus, jqXHR){
                    alert("以下是从服务器返回的对象:\n\n" + data + "\n\n id:" + data.id + "\n createTime:" + (new Date(data.createTime)).toLocaleDateString());
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
       	function getModelXml(){           
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/rest/orders/4.xml",               
                success: function(data, textStatus, jqXHR){
                    alert("以下是从服务器返回的对象:\n\n" + data.documentElement.outerHTML );
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
        
        function postModel(){           
            $.ajax({              
                type:"POST",
                dataType: "json",
                contentType: 'application/json;charset=UTF-8',
                data:JSON.stringify({"clientName":"Jim","amount":66,"createTime":1413947088717}),
                url:"${pageContext.request.contextPath}/rest/orders",               
                success: function(data, textStatus, jqXHR){
                     alert("以下是从服务器返回的对象:\n\n" + data + "\n\n id:" + data.id + "\n createTime:" + (new Date(data.createTime)).toLocaleDateString());
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
        
        function postModelXml(){           
            $.ajax({              
                type:"POST",
                dataType: "xml",
                contentType: 'application/xml',
                data:"<order><clientName>jimmy</clientName><amount>88</amount><createTime>2014-10-21 09:06:56.241 UTC</createTime></order>",
                url:"${pageContext.request.contextPath}/rest/orders",               
                success: function(data, textStatus, jqXHR){
                    alert("以下是从服务器返回的对象:\n\n" + data.documentElement.outerHTML);
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
	</script>
</body>
</html>