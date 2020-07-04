<%--
  Created by IntelliJ IDEA.
  User: hemu
  Date: 01/07/20
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Home | Easyweb</title>
</head>
<body>
    <h1>Welcome user....</h1>
    <h2>This is your Home. <% out.println(request.getParameter("email")); %></h2>
</body>
</html>
