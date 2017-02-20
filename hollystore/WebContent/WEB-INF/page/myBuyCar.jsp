<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
</head>
<body>
	<s:iterator value="#request.buyCar" var="info">
		<div style="display: inline;float: left;padding-left: 20px;text-align: center;">
			<div style="margin-left: auto; margin-right: auto;">
				<div><img src="image/${info.prodImg}"></div>
				 <div style="color: blue">
					购买的产品：${info.prodName} <br> 购买的数量：${info.prodStore }
				</div>
			</div>
			<br>
		</div>
	</s:iterator>

</body>
</html>