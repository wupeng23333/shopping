<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户管理</title>
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
            <strong style="font-size: 16px; margin: 5px 0;">用户管理</strong>
            <table class="table table-bordered">
                <tbody>
                <tr class="warning">
                    <th>用户id</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>姓名</th>
                    <th>邮箱</th>
                    <th>电话</th>
                    <th>性别</th>
                    <th>修改</th>
                </tr>
                <!-- 遍历List集合当中所有的值 -->
                <c:forEach items="${sessionScope.userList}" var="item">
                    <tr class="active">
                        <!-- 获取购物车上购物项上的图片 -->
                        <td width="10%">${item.uid}</td>
                        <td width="20%">${item.username}</td>
                        <td width="10%">${item.password}</td>
                        <td width="10%">${item.name}</td>
                        <td width="20%">${item.email}</td>
                        <td width="20%">${item.telephone}</td>
                        <td width="20%">${item.sex}</td>
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