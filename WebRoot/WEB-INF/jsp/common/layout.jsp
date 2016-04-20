<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="icon" href="http://getbootstrap.com/favicon.ico">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
	    <title>SSH Framework</title>
		
		<link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="<%=request.getContextPath() %>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
		
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css"/>
		
<%-- 		<title><tiles:getAsString name="title"/></title> --%>
	</head>

	<body role="document">
		
		<tiles:insert name="header" attribute="header" />
		
	    <div class="container" role="main">
			<tiles:insert name="body" attribute="body" />
		</div>
	
		<tiles:insert name="footer" attribute="footer" />
		
		
		<script src="<%=request.getContextPath() %>/js/jquery.min.js" ></script>
		<script src="<%=request.getContextPath() %>/js/bootstrap.min.js" ></script>
		
	</body>
</html>