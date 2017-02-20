<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<div
		style="margin-top: 50px;"
		align="center">
		<div style="width: 270px; height: 200px;">
			<form action="UserAction_register" method="post" style="margin: 50px;">
				<table>
					<tr>
						<td>*<font size="2" color="gray">账号：</font></td>
						<td><input type="text" name="account"></td>
					</tr>
					<tr>
						<td>*<font size="2" color="gray">姓名：</font></td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>*<font size="2" color="gray">密码：</font></td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
					    <td><font size="2" color="gray">年龄：</font></td>
						<td><input type="text" name="age"></td>
					</tr>
					<tr>
					   <td><font size="2" color="gray">地址：</font></td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
					    <td><font size="2" color="gray">Email：</font></td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
					    <td><font size="2" color="gray">单位：</font></td>
						<td><input type="text" name="company"></td>
					</tr>
					
					
				</table>
				<br>
				 <input type="submit" value="注册">
				 &nbsp;&nbsp;&nbsp;&nbsp;
				 <input type="reset" value="重置">
			</form>
		</div>
	</div>
</body>
</html>