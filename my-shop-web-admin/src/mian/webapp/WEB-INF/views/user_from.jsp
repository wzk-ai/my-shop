<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>我的商城 | 控制面板</title>

    <jsp:include page="../includes/header.jsp"></jsp:include>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="../includes/nav.jsp"></jsp:include>

    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>


        <!-- Main content -->
        <section class="content">
            <div class="col-md-12">
                <div class="box box-info">

                  <c:if test="${baseResult != null}">
                      <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible" >
                          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                              ${baseResult.message}
                      </div>
                  </c:if>

                    <div class="box-header with-border">
                        <h3 class="box-title">${tbUser.id==null ? "新增" : "编辑"}用户</h3>
                    </div>

                    <form:form cssClass="form-horizontal" action="/user/save" method="post" modelAttribute="tbUser">

                        <div class="box-body">
                            <div class="form-group">
                                <label for="email" class="col-sm-2 control-label">邮箱</label>

                                <div class="col-sm-10">
                                    <form:input path="email" cssClass="form-control" placeholder="请输入邮箱地址"></form:input>

                                </div>
                            </div>
                            <div class="form-group">
                                <label for="username" class="col-sm-2 control-label">姓名</label>

                                <div class="col-sm-10">
                                    <form:input path="username" cssClass="form-control" placeholder="请输入用户姓名"></form:input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phone" class="col-sm-2 control-label">手机</label>

                                <div class="col-sm-10">
                                    <form:input path="phone" cssClass="form-control" placeholder="请输入用户手机号"></form:input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-2 control-label">密码</label>

                                <div class="col-sm-10">
                                    <form:password path="password" cssClass="form-control" placeholder="请输入密码"></form:password>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> Remember me
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                            <button type="submit" class="btn btn-info pull-right">提交</button>
                        </div>
                        <!-- /.box-footer -->

                    </form:form>

                </div>

            </div>

        </section>

    </div>

    <jsp:include page="../includes/copyright.jsp"></jsp:include>

</div>


<jsp:include page="../includes/footer.jsp"></jsp:include>

</body>
</html>
