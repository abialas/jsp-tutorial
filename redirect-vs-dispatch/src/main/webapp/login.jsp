<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <form action="/login" method="post">
        <label for="user">User:</label>
        <input type="text" id="user" name="user">
        <br />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <br />

        <input type="submit" value="Login">
    </form>
</body>
</html>
