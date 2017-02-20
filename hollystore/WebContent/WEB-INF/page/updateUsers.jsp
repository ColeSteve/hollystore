<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息修改界面</title>

</head>
<body style="color: green;">

<div style="margin-top: 100px; margin-left: 300px; margin-right: 300px;"
		align="center">
<s:form method="post" action="UserAction_update">
   <table>
     <tr><td><s:hidden name="id"></s:hidden> </td></tr>
     <tr><td ><s:textfield name="name" label="姓名"></s:textfield></td></tr>
      <tr><td ><s:textfield name="account" label="账户"></s:textfield></td></tr>
      <tr><td ><s:textfield name="password" label="密码"></s:textfield> </td></tr>
     <tr><td><s:textfield name="age" label="年龄"></s:textfield></td></tr>
     <tr><td><s:textfield name="address" label="地址"></s:textfield></td></tr>
     <tr><td><s:textfield name="email" label="邮箱"></s:textfield></td></tr>
     <tr><td><s:textfield name="company" label="单位"></s:textfield></td></tr>
   </table>
   <input type="submit" value="确定修改">
</s:form>
</div>
</body>
</html>