<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>我的商城 | 用户列表</title>

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
                用户列表
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">

                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible" >
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>


                    <div class="box">
                        <div class="box-header">

                            <h3 class="box-title">用户列表</h3>

                            <div class="row" style="padding-left: 12px;padding-top: 10px">
                                <a href="/user/from" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a>
                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-trash-o"></i> 删除</a>
                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>
                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>
                            </div>

                            <div class="row" style="margin-top: 20px;">
                                <form class="form-horizontal" action="/user/search" method="post">
                                    <div class="row" >
                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label for="username" class="col-sm-2 control-label" >姓名</label>
                                                <div class="col-sm-8">
                                                    <input name="username" id="username" class="form-control" placeholder="姓名">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label for="email" class="col-sm-2 control-label" >邮箱</label>
                                                <div class="col-sm-8">
                                                    <input name="email" id="email" class="form-control" placeholder="邮箱">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label for="phone" class="col-sm-2 control-label" >手机</label>
                                                <div class="col-sm-8">
                                                    <input name="phone" id="phone" class="form-control" placeholder="手机">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row" style="padding-right: 88px">
                                        <div class="col-xs-12">
                                            <button type="submit" class="btn btn-info pull-right">搜索</button>
                                        </div>
                                    </div>
                                </form>


                            </div>




                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <tr>
                                    <td>
                                        <input type="checkbox" class="minimal icheck_master">
                                    </td>
                                    <th>用户ID</th>
                                    <th>用户名</th>
                                    <th>电话</th>
                                    <th>邮箱</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
                                </tr>

                                <c:forEach items="${tbUser}" var="tbUser">
                                    <tr>
                                        <td><input type="checkbox" class="minimal"></td>
                                        <td>${tbUser.id}</td>
                                        <td>${tbUser.username}</td>
                                        <td>${tbUser.phone}</td>
                                        <td><span class="label label-success">${tbUser.email}</span></td>
                                        <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                                        <td>
                                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-search"></i>查看</a>
                                            <a href="#" type="button" class="btn btn-sm btn-primary">编辑</a>
                                            <a href="#" type="button" class="btn btn-sm btn-danger">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>

    </section>

    </div>

    <jsp:include page="../includes/copyright.jsp"></jsp:include>

</div>


<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>

    var _checkbox=App.getCheckbox();

</script>
</body>
</html>
