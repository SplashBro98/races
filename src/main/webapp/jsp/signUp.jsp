<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 18.11.2018
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>SignUp_JSP</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h4>SignUp:</h4>

<div class="form-style-2">
    <form action="main" method="post">
        <input type="hidden" name="command" value="sign up">
        <label>Enter name:
            <input type="text" name="name" required/>
        </label>
        <label>Enter surname:
            <input type="text" name="surname" required/>
        </label>
        <label>Enter your login:
            <input type="text" name="login" required/> ${incorrect_login}
        </label>
        <label>Enter your password:
            <input type="password" name="password" required/>
        </label>
        <label>Enter your email:
            <input type="email" name="email" required/>
        </label>
        <label>Your type:
            <input type="text" name="userType" required/>
        </label>
        <input type="submit" value="SignUp">
    </form>
</div>



</body>
</html>
