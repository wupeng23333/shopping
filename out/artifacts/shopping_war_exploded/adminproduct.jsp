<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单管理</title>
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
            <strong style="font-size: 16px; margin: 5px 0;">商品管理</strong>
            <table class="table table-bordered">
                <tbody>
                <tr class="warning">
                    <th>商品号</th>
                    <th>商品名称</th>
                    <th>售价</th>
                    <th>图片位置</th>
                    <th>上架日期</th>
                    <th>是否热门</th>
                    <th>商品描述</th>
                    <th>分类号</th>
                    <th>修改</th>
                </tr>
                <!-- 遍历List集合当中所有的值 -->
                <c:forEach items="${sessionScope.productList}" var="item">
                    <tr class="active">
                        <!-- 获取购物车上购物项上的图片 -->
                        <td width="10%">${item.pid}</td>
                        <td width="15%">${item.pname}</td>
                        <td width="10%">${item.price}</td>
                        <td width="15%">${item.pimage}</td>
                        <td width="15%">${item.pdate}</td>
                        <td width="10%">${item.is_hot}</td>
                        <td width="20%">${item.pdescribe}</td>
                        <td width="10%">${item.cid}</td>
                        <td width="20%"><a href="adminorder.jsp">修改</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
