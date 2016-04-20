<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
		<link href="<%=request.getContextPath() %>/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
		<script src="<%=request.getContextPath() %>/js/bootstrap.js" type="text/script"></script>
		
<%-- 		<title><tiles:getAsString name="title"/></title> --%>
	</head>

	<body>
		<table width="100%" height="100%" border="0">
			<tr>
				<td valign="top" height="10px">
					<tiles:insert name="header" attribute="header" />
				</td>
			</tr>
			<tr>
				<td valign="middle" align="center">
					<tiles:insert name="body" attribute="body" />
				</td>
			</tr>
			<tr>
				<td height="10px">
					<tiles:insert name="footer" attribute="footer" />
				</td>
			</tr>
		</table>
	</body>
</html>