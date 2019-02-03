<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 02/02/2019
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pl.sdacademy.registration.UserDTO" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
        </tr>
        <% for (UserDTO user : (Collection<UserDTO>)request.getAttribute("users")) { %>
            <tr>
                <td><%= user.getFirstName() %></td>
                <td><%= user.getLastName() %></td>
                <td><%= user.getAddressDTO() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
