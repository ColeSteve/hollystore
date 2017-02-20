<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有产品</title>
</head>
<body>
<s:iterator value="#request.allProducts" var="product">
<a href="ProductAction_info?pid=${product.id}">
<div style="display: inline;float: left;padding-left: 20px;text-align: center;">
<div>
<img  src="image/${product.prodImg}">
</div>
<div style="margin-left: auto;margin-right: auto;color: green;">${product.prodDesc}  </div>
</div>
</a>
</s:iterator>
</body>
</html>