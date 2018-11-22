<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 21.11.2018
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add_Horse_JSP</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <form action="main" method="post">
        <input type="hidden" name="command" value="add horse">
        <label>Enter nickName:
            <input type="text" name="name" required>
        </label>
        <label>Enter age:
            <input type="text" name="age" pattern="[0-9]+" required>
        </label>
        <label>Enter count of wins:
            <input type="text" name="wins" pattern="[0-9]+" required>
        </label>
        <input type="submit" value="Add horse">
    </form>
</div>

</body>
</html>
