<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 02/02/2019
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Members list</title>
</head>
<body>
    <%@ include file="header.html" %>
    <c:choose>
        <c:when test="${not empty members}">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="memberAccount" items="${members}">
                    <tr>
                        <td>${memberAccount.firstName}</td>
                        <td>${memberAccount.lastName}</td>
                        <td>${memberAccount.addressDTO}</td>
                        <td><a href="memberView?memberId=${memberAccount.id}">Show member account</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>No members to display</p>
        </c:otherwise>
    </c:choose>
    <a href="memberCreate">Add new member account</a>
</body>
</html>
