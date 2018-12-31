<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <link href="/css/header.css" rel="stylesheet" type="text/css">
</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top" id="up">
    <a class="navbar-brand" href="#"><fmt:message key="title" bundle="${var}"/> </a>
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
