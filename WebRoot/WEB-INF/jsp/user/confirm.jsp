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
		</script>
	</head>

	<body class="body1">
		<form name="updateForm" target="_self" id="updateForm" action="user.do" method="post" onsubmit="return validateForm()">
			<input type="hidden" name="command" value="update">
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
							${form.email}
							<input type="hidden" name="email" value="${form.email}">
						</td>
					</tr>
				</table>
				
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnUpdate" class="button1" type="submit" id="btnUpdate" value="更新" >
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnModify" class="button1" type="button" id="btnModify" value="返回" onClick="location='<%=basePath%>user.do'">
				</div>
			</div>
		</form>
	</body>
</html>
