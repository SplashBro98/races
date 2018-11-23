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
    <title>Main_JSP</title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">

    <div class="header">
        <form class="form-style-2">
            <input type="text" name="query" size="30">
            <input type="submit" value="Search">
            <select name="type">
                <option>Race</option>
                <option>Horse</option>
            </select>
        </form>
    </div>

    <div class="sidebar1">
        <h4>List of Races</h4>
        <ul class="nav">
            <c:forEach items="${allRaces}" var="race">
            <li><a href="main?command=select race&name=${race.name}"/> ${race.name}</li>
                <%--<li>${race.name}</li>--%>
            </c:forEach>
        </ul>
    </div>

    <div class="content">

        <table class="nav" cols=1>
            <c:forEach items="${races}" var="race">
                <tr>
                    <td><h4>${race.name}</h4></td>
                </tr>
                <tr>
                    <td>Place: ${race.place}</td>
                </tr>
                <tr>
                    <td>Date: ${race.date}</td>
                </tr>
                <tr>
                    <td>Time: ${race.time}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="main" method="post" class="form-style-2">
        <input type="hidden" name="command" value="to add horse">
        <input type="submit" value="Add horse">
        </form>
        <form action="main" method="post" class="form-style-2">
        <input type="hidden" name="command" value="to delete horse">
        <input type="submit" value="Delete horse">
        </form>

    </div>



</div>






<%--<h4>List of horses:</h4>--%>
<%--<div class="form-style-2">--%>
    <%--<table>--%>
        <%--<tr class="form-style-2-heading">--%>
            <%--<td><h5>NickName</h5></td>--%>
            <%--<td><h5>Age</h5></td>--%>
            <%--<td><h5>Wins</h5></td>--%>
        <%--</tr>--%>
        <%--<c:forEach items="${horses}" var="horse">--%>
            <%--<tr>--%>
                <%--<td>${horse.name}</td>--%>
                <%--<td>${horse.age}</td>--%>
                <%--<td>${horse.wins}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
<%--</div>--%>
<%--<form action="main" method="post" class="form-style-2">--%>
    <%--<input type="hidden" name="command" value="to add horse">--%>
    <%--<input type="submit" value="Add horse">--%>
<%--</form>--%>
<%--<form action="main" method="post" class="form-style-2">--%>
    <%--<input type="hidden" name="command" value="to delete horse">--%>
    <%--<input type="submit" value="Delete horse">--%>
<%--</form>--%>



<%--<a href="/main?command=to login">to Login page</a>--%>



</body>
</html>
