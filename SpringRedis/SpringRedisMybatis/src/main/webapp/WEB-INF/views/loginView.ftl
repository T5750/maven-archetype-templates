<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8"/>
	<title>tomcat2登录页面</title>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script src="https://cdn.bootcss.com/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>
</head>
<body>
<h1 style="text-align: center">这是tomcat2的页面</h1>
<form id="loginForm" action="/doLogin">
	<div class="login_putin">
		<ul>
			<li>用户名：<input id="userName" name="userName" type="text"/></li>
			<li>密&nbsp&nbsp&nbsp码：<input id="userPwd" name="userPwd" type="text"/></li>
		</ul>
	</div>
	<div class="login_btn">
		<input type="button" value="登录" onclick="doLogin()">
	</div>
</form>
</body>
<script>
	function doLogin() {
		$.ajax({
			url: "/doLogin",
			type: "post",
			dataType: "json",
			data:
				{
					"userName": $("#userName").val(),
					"userPwd": $("#userPwd").val()
				},
			success: function (data) {
				if (data.success) {
					window.location.href = "/userCenter";
				} else {
					alert(data.msg);
				}
			}
		});
	}
</script>
</html>
