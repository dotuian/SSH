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

        <form id="updateForm" name="updateForm" class="form-horizontal" action="user.do" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input name="username" type="text" class="form-control" value="${userForm.username}" />
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input name="password" type="text" class="form-control" value="${userForm.password}" />
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-10">
                    <input name="email" type="email" class="form-control" value="${userForm.email}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="command" value="create">
                    <button id="btnCreate" name="btnCreate" type="submit" class="btn btn-primary">确认</button>
                </div>
            </div>
        </form>
    </div>


</div>