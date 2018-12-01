<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 25.11.2018
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add_Race_JSP</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <form action="main" method="post">
        <input type="hidden" name="command" value="add race">
        <label>Enter name:
            <input type="text" name="name" required>
        </label>
        <label>Enter place:
            <input type="text" name="place" required>
        </label>
        <label>Enter date:
            <input type="date" name="date" required>
        </label>
        <label>Enter time:
            <input type="time" name="time" required>
        </label>
        <input type="submit" value="Add race">
    </form>
</div>

</body>
</html>
