<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 23.11.2018
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete_JSP</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="main" method="post" class="form-style-2">
    <input type="hidden" name="command" value="delete horse">
    <label>Enter name:
        <input type="text" name="name" required>
    </label>
    <input type="submit" value="Delete">
</form>

</body>
</html>
