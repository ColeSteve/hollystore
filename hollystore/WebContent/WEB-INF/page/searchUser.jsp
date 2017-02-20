<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询指定用户信息</title>
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('#ss')
				.searchbox(
						{
							searcher : function(value, condition) {
								//alert(value + "," + condition);
							
									showContent('UserAction_searchUserByCondition?condition='
											+ condition+"&value="+value);
								
							},
						});
	});

	function showContent(tohref) {

		$("#pageurl").attr("src", tohref);
		//alert(tohref)
		//$('#main-center').href('/hollystore/WebContent/show.jsp');
	}
</script>
</head>
<body style="text-align: center;">
	<div style="margin-left: auto;margin-right: auto;">
		<input id="ss" class="easyui-searchbox" style="width: 300px"
			data-options="prompt:'请输入您要查询的内容',menu:'#mm'" name="condition"></input>
	</div>
	<div id="mm" style="width: 120px">
		<div data-options="name:'name'">按姓名查找</div>
		<div data-options="name:'address'">按地址查找</div>
	</div>


	<iframe id="pageurl" frameborder="0" scrolling="auto"
		style="width: 100%; height: 100%;">
		</ifranme>
</body>
</html>