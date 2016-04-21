<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<ul class="breadcrumb">
    <li><a href="${path}">主页</a></li>
    <li><a href="${path}user.do">用户</a></li>
    <li class="active">更新确认</li>
</ul>


<div class="row">

    <div class="col-lg-12">

        <form id="confirmForm" name="confirmForm" class="form-horizontal" action="user.do" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="username" class="form-control" value="${user.username}" readonly="true" />
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" value="${user.password}" readonly="true" />
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" value="${form.email}" readonly="true" />
                    <input type="hidden" name="email" value="${form.email}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id="btnBack" name="btnBack" type="button" class="btn btn-default" onclick="window.location='<%=basePath%>user.do?command=showDetail&id=${user.id}'">返回</button>
                    
                    <input type="hidden" name="command" value="update">
                    <input type="hidden" name="id" value="${user.id}">
                    <button id="btnConfirm" name="btnConfirm" type="submit" class="btn btn-primary">更新</button>
                </div>
            </div>
        </form>
    </div>


</div>