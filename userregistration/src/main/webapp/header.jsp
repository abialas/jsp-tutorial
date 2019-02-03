<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 03/02/2019
  Time: 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>This is header</p>
<% if (request.getParameter("name") != null) {%>
    <p>Hello from header: <%= request.getParameter("name")%></p>
<% } %>