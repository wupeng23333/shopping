<%@ page import="beans.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.CartItem" %>
<%@ page import="beans.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>购物车</title>
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


    <!-- 描述：菜单栏    -->
    <div class="container">
        <div class="row">
            <div style="margin: 0 auto; margin-top: 10px; width: 950px;">
                <strong style="font-size: 16px; margin: 5px 0;">订单详情</strong>
                <table class="table table-bordered">
                    <tbody>
                    <tr class="warning">
                        <th>图片</th>
                        <th>商品</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                        <th>操作</th>
                    </tr>
                    <!-- 遍历List集合当中所有的值 -->
                    <c:forEach items="${sessionScope.cart.list}" var="item">
                        <tr class="active">
                            <!-- 获取购物车上购物项上的图片 -->
                            <td width="60" width="40%"><input type="hidden" name="id" value="22">
                                <img src="${item.product.pimage}" width="70" height="60"></td>
                            <td width="30%"><a target="_blank">${item.product.pname}</a></td>
                            <td width="20%">${item.product.price}</td>
                            <td width="10%"><input type="text" name="quantity"
                                                   value="${item.num}" maxlength="4" size="10"></td>
                            <td width="15%"><span class="subtotal">￥${item.subTotal }</span></td>
                            <td><a href="/cartServlet?action=del&pid=${item.product.pid}" class="delete">删除</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div style="margin-right: 130px;">
            <div style="text-align: right;">
                <em style="color: #ff6600;">${sessionScope.cart.total }</em>&nbsp; 商品金额: <strong
                    style="color: #ff6600;">￥${sessionScope.cart.total }元</strong>
            </div>
            <div
                    style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
                <a href="/cartServlet?action=clear">清空购物车</a> <a
                    href="/orderServlet">
                <%--提交表单 --%> <input type="submit" width="100" value="提交订单"
                                     name="submit" border="0"
                                     style="height:35px;width:100px;color:black;">
            </a>
            </div>
        </div>
    </div>>

    </div>
</body>
</html>
