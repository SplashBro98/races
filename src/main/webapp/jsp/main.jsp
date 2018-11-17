<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 01.11.2018
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<html>
<head>
    <title>Main</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>



<h4>It`s a main page, bitch</h4>
<a href="/main?command=return">to Login page</a>

<%--<jsp:useBean id="horse" class="task.epam.race.entity.Horse"/>--%>


<%--<div class="form-style-2">--%>
    <%--<form action="start" method="POST">--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<label for="name">${enter1}:--%>
                    <%--<input class="input-field" type="text" id="name" name="name">--%>
                <%--</label>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<label for="age">${enter2}:--%>
                    <%--<input class="input-field" id="age" name="age">--%>
                <%--</label>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<label for="wins">${enter3}:--%>
                <%--<input class="input-field" id="wins" name="wins">--%>
                <%--</label>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<input type="submit" name="button" value="Добавить лошадь"/>--%>
            <%--</tr>--%>
        <%--</table>--%>
    <%--</form>--%>
    <%--<form action="signUp" method="get">--%>
        <%--<input type="submit" name="sign" value="Зарегистрироваться">--%>
    <%--</form>--%>
<%--</div>--%>

<%--<form action="start" method="GET">--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>Horse</td>--%>
            <%--<td>Age</td>--%>
            <%--<td>Wins</td>--%>
        <%--</tr>--%>
    <%--<c:forEach items="${horses}" var="horse">--%>
        <%--<tr>--%>
            <%--<td>${horse.name}</td>--%>
            <%--<td>${horse.age}</td>--%>
            <%--<td>${horse.wins}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</table>--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>User_id</td>--%>
            <%--<td>Name</td>--%>
            <%--<td>Surname</td>--%>
            <%--<td>Login</td>--%>
            <%--<td>Account</td>--%>
        <%--</tr>--%>
        <%--<c:forEach items="${users}" var="user">--%>
            <%--<tr>--%>
                <%--<td>${user.userId}</td>--%>
                <%--<td>${user.name}</td>--%>
                <%--<td>${user.surname}</td>--%>
                <%--<td>${user.login}</td>--%>
                <%--<td>${user.account}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>

<%--</form>--%>



</body>
</html>
