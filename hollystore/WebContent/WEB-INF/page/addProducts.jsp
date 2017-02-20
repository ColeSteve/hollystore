<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新的产品</title>
</head>
<body style="color: #ee5689">
	<div style="margin-top: 50px;" align="center">
		<div style="width: 500px; height: 200px;">
			<form action="ProductAction_saveProdInfo" method="post"
				style="margin: 50px;" enctype="multipart/form-data">
				<table>
					<tr>
						<td><font size="2" color="gray">产品名称：</font></td>
						<td><input type="text" name="prodName"></td>
					</tr>
					<tr>
						<td><font size="2" color="gray">产品类型：</font></td>
						<td><select name="prodType">
								<option value="connection" >通讯类产品</option>
						 
								<option value="software">软件类产品</option>
						 
								<option value="life">生活类产品</option>
						</select></td>
					</tr>
					<tr>
						<td><font size="2" color="gray">产品描述：</font></td>
						<td><textarea rows="3" cols="4" name="prodDesc" style="width: 178px; "></textarea></td>
					</tr>
					<tr>
						<td><font size="2" color="gray">产品库存量：</font></td>
						<td><input type="text" name="prodStore"></td>
					</tr>
					<tr>
						<td><font size="2" color="gray">产品图片：</font></td>
						<td><s:file name="myFile"></s:file> </td>
					</tr>


				</table>
				<input type="submit" value="上传产品">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="清除信息">
			</form>
		</div>
	</div>
</body>
</html>