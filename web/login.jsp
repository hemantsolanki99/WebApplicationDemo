<%--
  Created by IntelliJ IDEA.
  User: hemu
  Date: 30/06/20
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <form method="post" action="LoginServlet">
        <label>Email ID : </label> <input type="email" id="email" name="email" required>
        <br /><br />
        <label>Password :</label> <input type="password" id="password" name="password" required minlength="6">
        <br /><br />
        <button type="submit" name="submit">Login</button>
    </form>
</body>
</html>
