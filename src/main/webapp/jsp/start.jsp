<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 01.11.2018
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>${head}</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h4>${string}</h4>

<%--<jsp:useBean id="horse" class="task.epam.race.entity.Horse"/>--%>

<div class="select-field">
    <form action="start" method="get">
        <input type="submit" name="en_button" value="English"/>
        <input type="submit" name="ru_button" value="Русский"/>
        <input type="submit" name="de_button" value="Deutsch"/>
    </form>
</div>
<div class="form-style-2">
    <form action="start" method="POST">
        <label for="name">${enter1}:
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="age">${enter2}:
            <input class="input-field" id="age" name="age">
        </label>
        <label for="wins">${enter3}:
        <input class="input-field" id="wins" name="wins">
        </label>
        <input type="submit" name="button" value="Добавить лошадь"/>
    </form>
</div>
<form action="start" method="GET">
    <table>
        <tr>
            <td>Horse</td>
            <td>Years</td>
            <td>Wins</td>
        </tr>
    <c:forEach items="${horses}" var="horse">
        <tr>
            <td>${horse.name}</td>
            <td>${horse.age}</td>
            <td>${horse.wins}</td>
        </tr>
    </c:forEach>
    </table>
</form>

<%--<jsp:useBean id="date" class="java.time.LocalDate"/>--%>
<%--<h4> Текущее время:</h4> <c:out value="${date.atStartOfDay()}"/>--%>

</body>
</html>
