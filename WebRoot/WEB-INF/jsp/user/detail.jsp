<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<ul class="breadcrumb">
    <li><a href="${path}">主页</a></li>
    <li><a href="${path}user.do">用户</a></li>
    <li class="active">详细</li>
</ul>


<div class="row">

	<div class="col-lg-12">

		<form name="userForm" class="form-horizontal" id="userForm" action="user.do" method="post">
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-10">
                    <input name="username" type="text" class="form-control" value="${user.username}" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input name="password" type="text" class="form-control" value="${user.password}" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">邮箱</label>
				<div class="col-sm-10">
					<input name="email" type="email" class="form-control" value="${user.email}" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
			        <input type="hidden" name="command" value="deleteuser">
			        <input type="hidden" name="id" value="${user.id}">
					<button id="btnDelete" name="btnDelete" type="submit" class="btn btn-danger">删除</button>
					<button id="btnUpdate" name="btnUpdate" type="button" class="btn btn-primary" onclick="window.location='<%=basePath%>user.do?command=updateuser&id=${user.id}'">更新</button>
				</div>
			</div>
		</form>
	</div>


</div>