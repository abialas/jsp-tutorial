<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 03/02/2019
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member Account</title>
</head>
<body>
    <%@ include file="header.html" %>
    <br/>
    <br/>
    <label for="firstName">First name:</label>
    <span id="firstName">${memberAccount.firstName}</span>
    <br/>

    <label for="lastName">Last name:</label>
    <span id="lastName">${memberAccount.lastName}</span>
    <br/>

    <label for="address">Address:</label>
    <span id="address">${memberAccount.addressDTO}</span>
    <br/>

    <a href="memberCreate?memberId=${memberAccount.id}">Edit</a>
</body>
</html>
