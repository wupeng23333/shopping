<%@ page import="beans.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图书网上商城</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <style>
        body {
            margin-top: 20px;

        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        .container .row div {
            /* position:relative;
             float:left; */
        }

        font {
            color: #3164af;
            font-size: 18px;
            font-weight: normal;
            padding: 0 10px;
        }
    </style>
</head>
<body>

<div class="container-fluid">

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
                        <li><a href="${pageContext.request.contextPath}/categoryServlet?cid=1">小说</a></li>
                        <li><a href="${pageContext.request.contextPath}/categoryServlet?cid=2">艺术</a></li>
                        <li><a href="${pageContext.request.contextPath}/categoryServlet?cid=3">历史</a></li>
                        <li><a href="${pageContext.request.contextPath}/categoryServlet?cid=4">科技</a></li>
                        <li><a href="${pageContext.request.contextPath}/categoryServlet?cid=5">教育</a></li>
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



    <!--

        描述：商品显示
    -->

    <div class="row" style="width: 1210px; margin: 0 auto;">
        <c:forEach items="${sessionScope.categoryProduct }" var="p">
            <div class="col-md-2">
                <a href="${pageContext.request.contextPath}/productServlet?pid=${p.pid}">
                    <img
                            src="${p.pimage}"
                            width="170" height="170" style="display: inline-block;">
                </a>
                <p>
                    <a href="${pageContext.request.contextPath}/productServlet?pid=${p.pid}"
                       style='color: green'>${p.pname }</a>
                </p>
                <p>
                    <font color="#FF0000">商城价：&yen;${p.price }</font>
                </p>
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>