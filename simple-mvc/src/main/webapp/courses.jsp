<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 07/01/2019
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SDA - courses</title>
</head>
<body>
    <h1>Selected category: <%= request.getParameter("courseType")%></h1>
    <p>Available courses in selected category:</p>

    <%
        Collection courses = (Collection) request.getAttribute("courses");
        out.print("<select>");
        for (Object course : courses) {
            out.print("<option>" + course + "</option>");
        }
        out.print("</select>");
    %>
</body>
</html>
