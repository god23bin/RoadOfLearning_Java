<%--
  Created by IntelliJ IDEA.
  User: Bin
  Date: 2020/8/19
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SSM测试</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <style>
      .container-md{
        width: 600px;
      }
    </style>
  </head>
  <body>
    <div class="container container-md">
      <form class="form-group" action="register" method="post">
        ID：<input type="text" class="form-control" name="userId">
        手机号：<input type="text" class="form-control" name="phoneNumber">
        用户名：<input type="text" class="form-control" name="username">
        密码：<input type="password" class="form-control" name="password">
        <button class="btn btn-success btn-block" type="submit" >注册</button>
      </form>
    </div>
  </body>
</html>
