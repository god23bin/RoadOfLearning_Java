<%--
  Created by IntelliJ IDEA.
  User: Bin
  Date: 2020/8/14
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
    <head>
        <title>注册成功</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <style>
            .container-md{
                width: 600px;
            }
        </style>
    </head>
<body>
    <div class="container container-md">
        <h1>SSM测试，注册成功</h1>
        <h2>Model</h2>
        注册记录：${requestScope.count}<br>
    </div>
</body>
</html>
