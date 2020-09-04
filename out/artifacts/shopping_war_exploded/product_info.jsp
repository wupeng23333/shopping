<%@ page import="beans.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商品详情</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <style>
        body {
            margin-top: 20px;
            width: 100%;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>

<body>

<!--
        描述：菜单栏
    -->
<div class="container-fluid">
    <div class="col-md-3" style="padding-top: 20px">
        <ol class="list-inline">
            <li><a href="login.jsp">登录</a></li>
            <li><a
                    href="register.jsp">注册</a></li>
            <li><a href="cart.jsp">购物车</a></li>
            <li><a
                    href="order_list.jsp">我的订单</a></li>
        </ol>
    </div>
</div>
<!--
    描述：导航条
-->
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">首页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/categoryServlet?cid=1">小说</a></li>
                    <li><a href="/categoryServlet?cid=2">艺术</a></li>
                    <li><a href="/categoryServlet?cid=3">历史</a></li>
                    <li><a href="/categoryServlet?cid=4">科技</a></li>
                    <li><a href="/categoryServlet?cid=5">教育</a></li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</div>


<div class="container">
    <div class="row">
        <div style="margin:0 auto;width:950px;">
            <div class="col-md-6">
                <img style="opacity: 1;width:400px;height:350px;" title="" class="medium"
                     src="${sessionScope.product.pimage}">
            </div>
            <div class="col-md-6">
                <div><strong>${sessionScope.product.pname}</strong></div>
                <div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
                    <div>编号：${sessionScope.product.pid}</div>
                </div>
                <div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
                    <div>描述：${sessionScope.product.pdescribe}</div>
                </div>
                <div style="margin:10px 0 10px 0;">现价: <strong
                        style="color:#ef0101;">￥：${sessionScope.product.price}元</strong> 原价：
                    <del>￥：${sessionScope.product.price+10}元</del>
                </div>

                <div style="margin:10px 0 10px 0;">促销: <a target="_blank" title="限时抢购 (2020-07-01 ~ 2020-07-30)"
                                                          style="background-color: #f07373;">限时抢购</a></div>
                <form action="/cartServlet?action=add&pid=${sessionScope.product.pid}" method="post">
                    <div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">购买数量:
                        <input id="num" name="num" value="1" maxlength="4" size="10" type="text"></div>
                    <div style="margin:20px 0 10px 0;;text-align: center;">
                        <%--加入到购物车 --%>
                        <input style="height:36px;width:127px;"
                               value="加入购物车" type="submit">
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</div>


</body>

</html>
