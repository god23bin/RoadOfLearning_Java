<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %><%--
  Created by IntelliJ IDEA.
  User: Bin
  Date: 2020/7/25
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>HelloWorld</title>
  </head>
  <body>
    hello idea~Testing xxx
    <a href="TestServlet">测试下TestServlet</a>

    <%
      Context ctx = new InitialContext();
      String testJndi = (String) ctx.lookup("java:comp/env/jndiName");
      out.print(testJndi);
    %>
  </body>
</html>
