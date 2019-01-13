<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <form action="/login" method="post">
        <span>${validationMessages.login}</span>
        <br />

        <label for="user">User:</label>
        <input type="text" id="user" name="user">
        <span>${validationMessages.user}</span>
        <br />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <span>${validationMessages.password}</span>
        <br />

        <input type="submit" value="Login">
    </form>
</body>
</html>
