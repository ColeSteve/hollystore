<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数字框</title>
<!-- 引入Jquery -->
<script type="text/javascript" src="<%=path%>/js/easyui/jquery.min.js"
	charset="utf-8"></script>
<!-- 引入Jquery_easyui -->
<script type="text/javascript"
	src="<%=path%>/js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<!-- 引入easyUi国际化--中文 -->
<script type="text/javascript"
	src="<%=path%>/js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- 引入easyUi默认的CSS格式--蓝色 -->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/js/easyui/themes/default/easyui.css" />
<!-- 引入easyUi小图标 -->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/js/easyui/themes/icon.css" />
<%-- <script type="text/javascript" src="js/easyUIPagination.js"></script> --%>
<script type="text/javascript">
	$(function() {
		var editRow = undefined;
		$('#mydatagrid').datagrid(
				{
					title : '用户列表',
					iconCls : 'icon-ok',
					width : 1000,
					pageSize : 10,//默认选择的分页是每页5行数据  
					pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合  
					//nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
					striped : true,//设置为true将交替显示行背景。  
					collapsible : true,//显示可折叠按钮  
					toolbar : "#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
					url : 'PaginationAction_listUser',//url调用Action方法  
					loadMsg : '数据装载中......',
					singleSelect : true,//为true时只能选择单行  
					fitColumns : true,//允许表格自动缩放，以适应父容器  
					queryParams : {},//查询参数
					checkOnSelect : true,
					remoteSort : false,
					frozenColumns : [ [ {
						field : 'ck',
						checkbox : true
					} ] ],
					pagination : true,//分页  
					rownumbers : true,//显示行号
					toolbar : [
							{
								text : '删除',
								iconCls : 'icon-remove',
								handler : function() {
									var row = $("#mydatagrid").datagrid(
											"getSelected");
									if (row) {
										$.ajax({
											type : "POST",
											url : 'UserAction_deleteUser',
											data : "username=" + row.name,
											success : function(msg) {
												if (msg) {
													$.messager.alert('提示信息',
															'删除成功!', "info");
													$('#mydatagrid').datagrid(
															'reload');
												} else {
													$.messager.alert('提示信息',
															'删除失败!', "error");
												}
											}
										});

									}
								}

							},
							'-',
							{
								text : '编辑',
								iconCls : 'icon-edit',
								handler : function() {
									var rows = $('#mydatagrid').datagrid(
											'getSelections'); //得到所选择的行  
									if (rows.length == 1) {
										//changeEditorEditRow();//修改编辑的状态
										if (editRow != undefined) { //先判断双击前有没有在编辑的行  
											$('#mydatagrid').datagrid(
													'endEdit', editRow); //避免同时开启多个编辑行  
										}
										if (editRow == undefined) {
											var index = $('#mydatagrid')
													.datagrid('getRowIndex',
															rows[0]);//得到选择行的索引    
											$('#mydatagrid').datagrid(
													'beginEdit', index);
											editRow = index; //记录当前开启编辑的行  
											//在开启编辑状态时取消它的选择状态,这样就可以在修改时放弃修改当前行去修改其他行  
											$('#mydatagrid').datagrid(
													'unselectAll');
										}
									}
								}

							},
							'-',
							{
								text : '取消编辑',
								iconCls : 'icon-redo',
								handler : function() {
									editRow = undefined;
									$('#mydatagrid').datagrid('rejectChanges'); //调用回滚方法  
									$('#mydatagrid').datagrid('unselectAll');
								}
							},
							'-',
							{
								text : '保存',
								iconCls : 'icon-save',
								handler : function() {
									$("#mydatagrid").datagrid('endEdit',
											editRow);
									//如果调用acceptChanges(),使用getChanges()则获取不到编辑和新增的数据。
									//var rows = $("#mydatagrid").datagrid('getChanges');
									//使用JSON序列化datarow对象，发送到后台。
									//var rowstr = JSON.stringify(rows);
									//var username=rows[0].name;
									//
									//alert(rowstr);

								}
							},
							'-',
							{
								text : '添加',
								iconCls : 'icon-add',
								handler : function() {
									if (editRow != undefined) {
										$("#mydatagrid").datagrid('endEdit',
												editRow);//避免开启多个编辑行
									}
									if (editRow == undefined) {
										$("#mydatagrid").datagrid('insertRow',
												{
													index : 0,
													row : {
														name : '请输入用户名',
														age : '请输入年龄',
														address : '请输入地址',
														account : '请输入账号',
														password:'请输入密码',
														email : '请输入邮箱',
														company : '请输入单位',
													}

												});
										//让添加的新一行开启编辑状态
										$("#mydatagrid").datagrid('beginEdit',
												0);
										editRow = 0;//记录当前编辑的索引
									}
								}
							} ],

					onAfterEdit : function(rowIndex, rowData, changes) {
						//新增一行
						var inserted = $('#mydatagrid').datagrid('getChanges',
								'inserted'); //得到插入的数据  
						//编辑当前行
						var updated = $('#mydatagrid').datagrid('getChanges',
								'updated'); //得到修改的数据  
						//即没有选择添加也没有选择修改就直接return结束,不往下面走了  不然url提交地址为空  

						if (inserted.length < 1 && updated.length < 1) {
							editRow = undefined;
							datagrid.datagrid('unselectAll');
							return;
						}
						var url = '';
						if (inserted.length > 0) { //表示点击的添加按钮  
							url = 'UserAction_saveUser';
						}
						if (updated.length > 0) { //表示点击的编辑按钮  
							url = 'UserAction_updateUser';
						}
						console.log(rowData);
						$.ajax({
							url : url,
							data : rowData,
							success : function(msg) {
								$.messager.alert('提示信息', '成功!', "info");
								$('#mydatagrid').datagrid('reload');
								editRow = undefined;
								$('#mydatagrid').datagrid('unselectAll'); //取消选中,避免出现黄色条  
							}
						});
					},

					onDblClickRow : function(rowIndex, rowData) {
						if (editRow != undefined) {
							$("#mydatagrid").datagrid('endEdit', editRow);
						}

						if (editRow == undefined) {
							$("#mydatagrid").datagrid('beginEdit', rowIndex);
							editRow = rowIndex;//记录当前编辑的索引
						}
					},
					onClickRow : function(rowIndex, rowData) {
						if (editRow != undefined) {
							$("#mydatagrid").datagrid('endEdit', editRow);

						}

					}

				});

		$("#submit_search").linkbutton({
			iconCls : 'icon-search',
			plain : true
		}).click(function() {
			var queryParams = $('#mydatagrid').datagrid('options').queryParams;
			var value = $('#search_value').val();
			var condition = $('#search_type').val();
			if (condition == 'name') {
				queryParams.address = "";
				queryParams.username = value;
			}
			if (condition == 'address') {
				queryParams.username = "";
				queryParams.address = value;
			}
			$('#mydatagrid').datagrid("reload");
		});

	});

	function sort() {
		$('#mydatagrid').datagrid({
			sortName : 'age',//当数据表格初始化时以哪一列来排序  
			sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。  
		});
	}

	//将表单数据转为json
	function form2Json(id) {

		var arr = $("#" + id).serializeArray()
		var jsonStr = "";

		jsonStr += '{';
		for (var i = 0; i < arr.length; i++) {
			jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
		}
		jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
		jsonStr += '}';
		console.log(jsonStr);
		var json = JSON.parse(jsonStr);

		return json;
	}
	
 function exportFile() {
		$.ajax({
			url:"UserAction_export",
			data:{},
			success:function(msg){
				alert("导出成功!");
			}
			
		})
	}
</script>
</head>
<body>
	   <tr>
		<td width="70" height="30">条件检索:</td>
		<td height="30"><input type="text" name="condition" size=20
			id="search_value"> <select name="value" id="search_type">
				<option value="-1">请选择搜索类型</option>
				<option value="name">按姓名搜索</option>
				<option value="address">按地址搜索</option>
		</select> <a id="submit_search">搜索</a></td>
        <tr>
	    <div style="float: right;display: inline;margin-right: 150px;">
	      <a onclick="exportFile()">
	        <button>导出数据</button>
	      </a>
	    </div>
	
	<table id="mydatagrid">

		<thead>
			<tr>
				<th
					data-options="field:'name',width:100,align:'center',editor: { type: 'text', options: { required: true } }">姓名</th>
				<th
					data-options="field:'age',width:100,align:'center',sortable:true,editor: { type: 'text', options: { required: true } }"
					onclick="sort()">年龄</th>
				<th
					data-options="field:'address',width:100,align:'center',editor: { type: 'text', options: { required: true } }">地址</th>
				<th
					data-options="field:'account',width:100,align:'center',editor: { type: 'text', options: { required: true } }">账户</th>
				<th
					data-options="field:'password',width:100,align:'center',editor: { type: 'text', options: { required: true } }">密码</th>

				<th
					data-options="field:'email',width:100,align:'center',editor: { type: 'text', options: { required: true } }">邮箱</th>
				<th
					data-options="field:'company',width:100,align:'center',editor: { type: 'text', options: { required: true } }">单位</th>

			</tr>
		</thead>

	</table>
</body>
</html>