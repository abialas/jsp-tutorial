<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 25/01/2019
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Hello World Servlet</title>
    </head>
    <body>
        <p>Hello World! <br>Dzisiaj jest <% out.print(LocalDateTime.now()); %>!</p>
    </body>
</html>