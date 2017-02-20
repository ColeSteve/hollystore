<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录/注册</title>
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function register() {
		$('#dd').dialog({
			title : '注册页面',
			width : 500,
			height : 400,
			closed : false,
			cache : false,
			//resizable : true,
			href : 'register.jsp',
			modal : true,//设置该属性，则不能操作其他界面
		});
	}

	function refresh() {
		document.getElementById("identify").src = "identifyCode.jsp?time="
				+ new Date();
	}

	//输入验证
	function tips(iCode) {

	}
</script>
</head>
<%
	String account = "";
	String password = "";
	String checked = "";
	
	//获取存入的cookie
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0) {

		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if ("account".equals(cookie.getName())) {
				//解码，使得回显在用户名输入框中的中文部分不会出现乱码
				account =URLDecoder.decode(cookie.getValue(), "utf-8");
				// name=cookie.getValue();
				checked = "checked";
			}
			if ("password".equals(cookie.getName())) {
				password = cookie.getValue();

			}
			
		}

	}
%>
<body style="background-image: url('image/background.jpg');">
	<div
		style="margin-top: 200px; margin-left: 300px; margin-right: 300px;"
		align="center">
		<div style="width: 500px; height: 200px; padding: 20px; border: 10px;">
			<span style="color: green;">科技生活，从这里开始</span>
			<form action="UserAction_login" method="post" style="margin: 50px;">
				<table>
					<tr>
						<td><font size="5" color="gray">账 &nbsp;&nbsp;号：</font></td>
						<td><input id="acc" type="text" name="account" value="<%=account %>"></td>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr>
						<td><font size="5" color="gray">密 &nbsp;&nbsp;码：</font></td>
						<td><input type="password" name="password" value="<%=password%>"></td>
					</tr>
					<tr>
						<td><font size="5" color="gray">验证码：</font></td>
						<td><input type="text" size="10" name="idCode">&nbsp;<img
							id="identify" src="identifyCode.jsp" onclick="refresh()"></td>
					</tr>
					<tr>
						<td><font size="5" color="gray">记住我：</font></td>
						<td><input type="checkbox" name="rememberMe" <%=checked%>></td>
					</tr>
					<tr>
						<s:fielderror name="loginError"></s:fielderror>
					</tr>
				</table>
				<br> <a onclick="register()"><button type="button"
						name="register">注册</button> </a> &nbsp;&nbsp; &nbsp;&nbsp;
				&nbsp;&nbsp; &nbsp; <input type="submit" value="登录">
			</form>
		</div>
	</div>

	<div id="dd" style="background-color: E1F5DC;"></div>
</body>

</html>