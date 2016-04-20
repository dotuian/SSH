<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改物料</title>
		<link rel="stylesheet" href="style/drp.css">
		<script src="script/client_validate.js"></script>
		<script type="text/javascript">
			function validateForm() {
// 				if (trim(document.getElementById("itemName").value) == "") {
// 					alert("物料名称不能为空！");
// 					document.getElementById("itemName").focus();
// 					return false;
// 				}
				return true;
			}
		</script>
	</head>

	<body class="body1">
		<form name="updateForm" target="_self" id="updateForm" action="user.do" method="post" onsubmit="return validateForm()">
			<input type="hidden" name="command" value="confirmuser">
			<input type="hidden" name="id" value="${user.id}">
				
				<table width="95%" border="1" cellspacing="0" cellpadding="0" align="center" class="table1">
					<tr>
						<td width="155" class="rd6">用户名</td>
						<td class="rd8">${user.username}</td>
					</tr>
					<tr>
						<td width="155" class="rd6">密码</td>
						<td class="rd8">${user.username}</td>
					</tr>
					<tr>
						<td width="155" class="rd6">邮箱</td>
						<td class="rd8">
							<input name="email" type="text" class="text1" id="email" size="50" maxlength="50" value="${user.email}">
						</td>
					</tr>
				</table>
				
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnConfirm" class="button1" type="submit" id="btnConfirm" value="确认" >
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnModify" class="button1" type="button" id="btnModify" value="返回" onClick="location='<%=basePath %>item.do'">
				</div>
			</div>
		</form>
	</body>
</html>
