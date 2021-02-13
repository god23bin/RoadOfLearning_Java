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
        <title>成功，欢迎使用SpringMVC</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <style>
            .container-md{
                width: 600px;
            }
        </style>
    </head>
<body>
    <div class="container container-md">
        <h1>Hello，SpringMVC，欢迎您的使用</h1>
        <h2>试试有没有样式</h2>
        <h2>ModelAndView</h2>
        name：${requestScope.student1.name}<br>
        age：${requestScope.student1.age}
        <h2>ModelMap</h2>
        name：${requestScope.student2.name}<br>
        age：${requestScope.student2.age}
        <h2>Map &lt String,Object &gt</h2>
        name：${requestScope.student3.name}<br>
        age：${requestScope.student3.age}
        <h2>Model</h2>
        name：${requestScope.student4.name}<br>
        age：${requestScope.student4.age}
    </div>
</body>
</html>
