<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品具体信息</title>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function buyProd(pid) {
	  $.post("ProductAction_buyProduct",
			  {
			    pid:pid,
			  },
			  function(data){
				 alert("恭喜您！购买成功.")
				 var s=$.trim($('div .store').text());
			     var v1=s.substr(8,15);
			     var v2=$.trim(v1);
			     v3=parseInt(v2)-1;
			   $('div .store').html("该产品库存量为：	"+v3);
			   
			  }
			);
} 
</script>
</head>
<body style="text-align: center;">
	<s:set value="#request.products" var="product">
	</s:set>
	<div style="margin-left: auto; margin-right: auto;">
		<div>
			<img src="image/${product.prodImg}">
		</div>
		<div style="color: maroon;">
			<s:property value="#request.products.prodDesc" />
		</div>
		<div class="store">
			该产品库存量为：
			<s:property value="#request.products.prodStore" />
		</div>
	</div>
	<!-- 显示页面访问量 -->
	<%
		Integer hitsCount = (Integer) application.getAttribute("hitCounter");
		if (hitsCount == null || hitsCount == 0) {
			/* 第一次访问 */
			hitsCount = 1;
		} else {
			/* 返回访问值 */
			hitsCount += 1;
		}
		application.setAttribute("hitCounter", hitsCount);
	%>

	<p>
		页面访问量为: <b><u> <%=hitsCount%></u></b>
	</p>
	<div>
		<button type="submit" style="width: 70px; height: 30px; color: red"
			title="购买" onclick="buyProd(${product.id})">购买</button>
	</div>

</body>
</html>