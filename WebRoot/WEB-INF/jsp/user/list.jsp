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
		<title>用户列表</title>
		<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" >
		<link rel="stylesheet" href="<%=basePath%>/css/bootstrap-theme.min.css" >
		
		<script src="<%=basePath%>/js/bootstrap.min.js"></script>
	</head>

	<body>
	
			<div align="center">
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
					<tr>
						<td><a href="<%=basePath%>user.do?command=createuser"> 创建用户 </td>					
					</tr>
				</table>
				
				<hr width="97%" align="center" size=0>

			<form name="userSearchForm" target="_self" id="userSearchForm" action="user.do" method="get">
				<input type="hidden" name="command" value="query">
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="17%" height="29">
							<div align="left">
								用户名:
							</div>
						</td>
						<td width="57%">
							<input name="key" type="text" id="key" size="50" maxlength="50" value="${param.key}">
						</td>
						<td width="26%">
							<div align="left">
								<input id="btnQuery" name="btnQuery" class="button" type="submit" value="查询">
							</div>
						</td>
					</tr>
					<tr>
						<td height="16">
							<div align="right"></div>
						</td>
						<td>
							&nbsp;
						</td>
						<td>
							<div align="right"></div>
						</td>
					</tr>
				</table>
			</form>

			</div>
			
			
			
			<h4>用户列表</h4>
			<table class="table table-bordered table-responsive table-hover">
				<tr>
					<td>用户名</td>
					<td>密码</td>
					<td>邮箱</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${userlist}" var="user" varStatus="myIndex">
					<tr class="${myIndex.index %2 == 0 ? "info" : ""}" >
						<td>
							${user.username}
						</td>
						<td>
							${user.password}
						</td>
						<td>
							${user.email}
						</td>
						<td>
							<a href="<%=basePath%>user.do?command=showDetail&id=${user.id}" >详细</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
		
	</body>
</html>
