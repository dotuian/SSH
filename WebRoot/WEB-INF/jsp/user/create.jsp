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

				return true;
			}
		</script>
	</head>

	<body class="body1">
		<form name="createUserForm" target="_self" id="createUserForm" action="user.do" method="post" onsubmit="return validateForm()">
			<input type="hidden" name="command" value="create">
				<table width="95%" border="1" cellspacing="0" cellpadding="0" align="center" class="table1">
					<tr>
						<td width="155" class="rd6">用户名</td>
						<td class="rd8"><input name="username" type="text" size="50" maxlength="50" value="${userForm.username}"></td>
					</tr>
					<tr>
						<td width="155" class="rd6">密码</td>
						<td class="rd8"><input name="password" type="text" size="50" maxlength="50" value="${userForm.password}"></td>
					</tr>
					<tr>
						<td width="155" class="rd6">邮箱</td>
						<td class="rd8"><input name="email" type="text" size="50" maxlength="50" value="${userForm.email}"></td>
					</tr>
				</table>
				
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input id="btnCreate" name="btnCreate" class="button1" type="submit"  value="创建" >
				</div>
			</div>
		</form>
	</body>
</html>
