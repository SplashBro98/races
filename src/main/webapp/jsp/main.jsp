<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 01.11.2018
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Main_JSP</title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<div>

    <nav class="navbar navbar-light bg-light">

        <form class="form-inline">
            <input type="text" name="query" size="30">
            <input type="submit" value="Search">
            <select name="type">
                <option>Race</option>
                <option>Horse</option>
            </select>
        </form>
        <h5>${login}</h5>
        <form class="form-inline">
            <input type="hidden" name="command" value="log out">
            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Log Out"/>
        </form>
    </nav>

    <div class="container">
        <h4>List of Races</h4>
            <c:forEach items="${allRaces}" var="race">
                <div class="row">
                <a href="main?command=select race&name=${race.name}"/> ${race.name} <br/>
                </div>
            </c:forEach>
        <form action="main" method="post" class="form-style-2">
            <input type="hidden" name="command" value="to add race">
            <input type="submit" value="Add Race">
        </form>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-2">Name</div>
            <div class="col-md-2">Place</div>
            <div class="col-md-2">Date</div>
            <div class="col-md-2">Time</div>
        </div>
        <c:forEach items="${allRaces}" var="race">
            <div class="row">
                <div class="col-md-2">${race.name}</div>
                <div class="col-md-2">${race.place}</div>
                <div class="col-md-2">${race.date}</div>
                <div class="col-md-2">${race.time}</div>
            </div>
        </c:forEach>
        <%--<form action="main" method="post" class="form-style-2">--%>
        <%--<input type="hidden" name="command" value="to add horse">--%>
        <%--<input type="submit" value="Add horse">--%>
        <%--</form>--%>
        <%--<form action="main" method="post" class="form-style-2">--%>
        <%--<input type="hidden" name="command" value="to delete horse">--%>
        <%--<input type="submit" value="Delete horse">--%>
        <%--</form>--%>

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
