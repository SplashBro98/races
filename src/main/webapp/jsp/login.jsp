<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 01.11.2018
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>SignUp_JSP</title>
    <meta charset="utf-8">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h4>Registration:</h4>

<div class="form-style-2">
    <form action="signUp" method="post">
        <%--<input type="hidden" name="command" value="login">--%>
        <label>Enter your name:
            <input type="text" name="name">
        </label>
        <label>Enter your surname:
            <input type="text" name="surname">
        </label>
        <label>Enter login:
            <input type="text" name="login">
        </label>
        <label>Enter password:
            <input type="text" name="password">
        </label>
        <label>Confirm password:
            <input type="text" name="name">
        </label>
        <input type="submit" name="button" value="Зарегистрироваться">
    </form>
</div>

</body>
</html>
