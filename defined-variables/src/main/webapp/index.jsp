<%@ page import="java.time.Instant" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 27/12/2018
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Defined variables</title>
</head>
<body>
    <p>Request URL: <%= request.getRequestURL().toString() %></p>
    <p>Request Servlet Path: <%= request.getServletPath() %></p>
    <p>Request Query String: <%= request.getQueryString() %></p>
    <p>Request Parameters: <%= String.join(", ", Collections.list(request.getParameterNames())) %></p>

    <p>Application Name: <%= application.getServerInfo() %></p>

    <p>Session ID: <%= session.getId() %></p>
    <p>Session Creation Time:
        <%= Instant.ofEpochMilli(session.getCreationTime()).atZone(ZoneId.systemDefault()).toLocalDateTime() %>
    </p>
    <p>Session IsNew: <%= session.isNew() %></p>

</body>
</html>
