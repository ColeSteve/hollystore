<%@page import="com.holly.domain.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {

	});

	function showContent(tohref) {

		$("#pageurl").attr("src", tohref);
		//alert(tohref)
		//$('#main-center').href('/hollystore/WebContent/show.jsp');
	}

	function showProduct(toProd) {
		$("#pageurl").attr("src", toProd);
	}
</script>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body class="easyui-layout">
	<s:set value="#request.user" var="user"></s:set>
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding: 10px">
		<div
			style="float: left; display: inline; font-size: 30px; font-family: monospace; color: #345678">
			E家◆智汇 
		</div>
		<div
			style="float: right; padding-right: 4px; padding-top: 5px; display: inline; font-size: 20px; font-style: oblique;">
			<font color="#345678"><marquee behavior="scroll"
					scrolldelay="10">
					欢迎您☞☞☞<font color="blue">${user.name}</font>☜☜☜
				</marquee></font>

			<%
				//将当前登录用户存入Session当中
				Users users = (Users) request.getAttribute("user");
				session.setAttribute("currentUser", users);
			%>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'选择菜单'"
		style="width: 200px; padding: 10px;">
		<div id="aa" class="easyui-accordion"
			style="width: 150px; height: 400px;">
			<%
				if (users.getIsAdmin() == 1) {
			%>
			<div title="用户管理" data-options="selected:true" style="padding: 10px;">
				<ul id="tt" class="easyui-tree">
					<li><span> <a href="#"
							onclick="showContent('UserAction_list')">用户管理</a>
					</span></li>
					<li><span> <a href="#"
							onclick="showContent('UserAction_search')">查询指定用户信息</a>
					</span></li>
				</ul>
			</div>

			<%
				}
			%>
			<div title="个人中心" data-options="selected:true" style="padding: 10px;">
				<ul id="tt" class="easyui-tree">
					<li><span>个人信息</span>
						<ul>
							<li><span><a
									onclick="showContent('UserAction_updateUsers?username=${user.name }')">账户管理</a></span></li>
							<li><span>其他</span>
						</ul></li>
					<li><span><a href="#"
							onclick="showProduct('ProductAction_myBuyCar')">我的购物车</a></span></li>

				</ul>
			</div>

			<div title="产品管理" data-options="selected:true">
				<ul id="tt" class="easyui-tree">
					<li><span><a
							onclick="showProduct('ProductAction_showAllProducts')">所有产品</a></span></li>
					<%-- <li><span>产品信息</span>
						<ul>
							<li><span><a
									onclick="showProduct('ProductAction_connection')">通讯类产品</a></span> <!-- <ul>
									<li><span><a href="#" onclick="showProducts('ProductAction_apple')">苹果</a></span></li>
									<li><span>小米</span></li>
									<li><span>三星</span></li>
								</ul></li> -->
							<li><span><a
									onclick="showProduct('ProductAction_software')">软件类产品</a></span> <!-- <ul>
									<li><span><a href="#">云呼叫中心</a></span></li>
									<li><span>电话会议</span></li>
									<li><span>企业IM-小秘</span></li>
								</ul></li> -->
							<li><span><a
									onclick="showProduct('ProductAction_life')">生活类产品</a></span> <!-- <ul>
									<li><span><a href="#">床</a></span></li>
									<li><span>沙发</span></li>
									<li><span>衣柜</span></li>
								</ul></li> -->
						</ul></li> --%>
					<%
						if (users.getIsAdmin() == 1) {
					%>
					<li><span>产品管理</span>
						<ul>
							<li><span><a
									onclick="showProduct('ProductAction_addProducts')">添加产品</a></span></li>
							<li><span><a
									onclick="showProduct('ProductAction_checkProdStore')">查看库存</a></span></li>

						</ul></li>

					<%
						}
					%>
				</ul>
			</div>
		</div>


	</div>
	<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width: 130px; padding: 10px;">
		<span style="font-style: oblique; font-size: 15px;">&nbsp;最新动态</span>
		<div style="width: 80px; padding-top: 20px;">敢为人先，追求卓越</div>
	</div>
	<div data-options="region:'south',border:false"
		style="height: 30px; background: #A9FACD; padding: 10px;">
		<center style="align: bottom; color: red;">&copy
			武汉工程大学计算机学院  网络工程专业 版权所有 2016-2022</center>
	</div>
	<div id="main-center" data-options="region:'center',"
		style="background-image: url('image/background.jpg');">
		<iframe id="pageurl" frameborder="0" scrolling="auto"
			style="width: 100%; height: 100%;">

			</ifranme>
			<!-- <a href="UserAction_list">所有用户</a> -->
	</div>


</body>
</html>