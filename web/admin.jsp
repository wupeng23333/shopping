<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员</title>
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
<div class="container">
    <div class="row">
        <div style="margin: 0 auto; margin-top: 10px; width: 950px;">
            <strong style="font-size: 16px; margin: 5px 0;">尊敬的管理员：admin,你好！</strong>
            <table class="table table-bordered">
                <tbody>
                <tr class="warning">
                    <th><a href="/adminServlet?action=category">分类管理</a></th>
                    <th><a href="/adminServlet?action=product">商品管理</a></th>
                    <th><a href="/adminServlet?action=order">订单管理</a> </th>
                    <th><a href="/adminServlet?action=user">用户管理</a> </th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
