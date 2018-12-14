<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 13.12.2018
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title>Title</title>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top" id="up">
    <a class="navbar-brand" href="#">Races</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <form action="/main" method="post">
                    <input type="hidden" name="command" value="change language">
                    <input type="hidden" name="locale" value="ru_RU">
                    <input type="submit" class="btn btn-success" value="RU">
                </form>
            </li>
            <li class="nav-item">
                <form action="/main" method="post">
                    <input type="hidden" name="command" value="change language">
                    <input type="hidden" name="locale" value="en_EN">
                    <input type="submit" class="btn btn-success" value="EN">
                </form>
            </li>

        </ul>
    </div>
</nav>

</body>
</html>
