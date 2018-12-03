<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 01.11.2018
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Login_JSP</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h4>${incorrect}</h4>

<div class="form-style-2">
    <form action="main" method="post">
        <input type="hidden" name="command" value="log_in">
        <label>Enter login:
            <input type="text" name="login" required>
        </label>
        <label>Enter password:
            <input type="password" name="password" required>
        </label>
        <input type="submit" value="Sign In"/>
    </form>
    <form action="main" method="post">
        <input type="hidden" name="command" value="to sign up">
        <input type="submit" value="Sign Up">
    </form>
</div>

</body>
</html>
