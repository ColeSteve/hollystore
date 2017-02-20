<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/struts-tags"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
function enDelete(name){
	var b=confirm("您确定删除该用户？")
	if(!b){
		return;
	}
}
</script>
</head>
<body>
	<table background="blue" cellpadding="1" bordercolor="#efefef"
		border="1" align="center" width="600px" style="text-align: center;">
		<thead valign="top"></thead>
		<tr>
			<td>姓名</td>
			<td>地址</td>
			<td>账户</td>
			<td>邮件地址</td>
			<td>所属单位</td>
			<td>删除该用户</td>
		</tr>
		<c:iterator value="#request.userList" var="user">
			<tr>
				<td>
				<a  href="UserAction_updateUsers?username=${user.name }" style="text-decoration: none;">${user.name}</a>
				</td>
				<td>${user.address}</td>
				<td>${user.account }</td>
				<td>${user.email }</td>
				<td>${user.company}</td>
				<td><a id="del" href="UserAction_deleteUser?username=${user.name}" style="text-decoration: none;">删除</a></td>
			</tr>
		</c:iterator>
        
	</table>
	<!-- <div class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;width:597px;margin-right: auto;margin-left: auto;"
        data-options="total:2000,pageSize:10"></div> -->
	
</body>
</html>