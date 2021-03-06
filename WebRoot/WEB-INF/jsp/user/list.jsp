<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    


<ul class="breadcrumb">
    <li><a href="${path}">主页</a></li>
    <li><a href="${path}user.do">用户</a></li>
    <li class="active">用户一览</li>
</ul>


<div class="row">
    <div class="col-lg-12">
        <form name="userSearchForm" id="userSearchForm" action="user.do" method="get">
            <div class="form-group">
                <label for="key">查询关键字</label>
                <input name="key" type="text" value="${param.key}" class="form-control">
            </div>
            <input type="hidden" name="command" value="query">
            <input id="btnQuery" name="btnQuery" class="btn btn-default pull-right" type="submit" value="查询">
        </form>
    </div>
</div>


<!-- 
<div class="page-header">
</div>
 -->
<h4>用户一览表</h4>
<div class="row">
    <div class="col-md-12">
        <table class="table table-bordered table-responsive table-hover">
            <tr>
                <th>用户名</th>
                <th>密码</th>
                <th>邮箱</th>
                <th>操作</th>
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
    </div>
</div>
