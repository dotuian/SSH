<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细</title>
<link rel="stylesheet" href="style/drp.css">
</head>

<body class="body1">

	<table width="95%" border="0" cellspacing="2" cellpadding="2">
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
	</table>
	<table width="95%" border="0" cellspacing="0" cellpadding="0"
		height="8">
		<tr>
			<td width="522" class="p1" height="2" nowrap>
				<img src="images/mark_arrow_02.gif" alt="我" width="14"
					height="14">
				&nbsp;
				<b><a href="<%=basePath%>user.do"> 用户</a>&gt;&gt;列表</b>
			</td>
		</tr>
	</table>

	<form name="userForm" target="_self" id="userForm" action="user.do" method="post">
		<input type="hidden" name="command" value="deleteuser">
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
				<td class="rd8">${user.email}</td>
			</tr>
		</table>

		<input id="btnDelete" name="btnDelete" class="button" type="submit" value="删除">
		
		<input id="btnUpdate" name="btnUpdate" class="button" type="button" value="更新" onclick="window.location='<%=basePath%>user.do?command=updateuser&id=${user.id}'">
	</form>
</body>
</html>
