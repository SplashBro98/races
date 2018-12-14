<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 05.12.2018
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title>Header</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/start.css" rel="stylesheet" type="text/css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top" id="up" style="background-color: #263238">
    <a class="navbar-brand" href="#">Races</a>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <a class="nav-link" href="/main?command=to main"><h5>
                <fmt:message key="header.main" bundle="${var}"/></h5></a>
        </li>
    </ul>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">${role}:  ${login}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main?command=to profile"><fmt:message key="header.profile" bundle="${var}"/>
                    <span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item">
                <form>
                    <input type="hidden" name="command" value="log out">
                    <input type="submit" class="btn btn-success" value=<fmt:message key="header.logout" bundle="${var}"/>>
                </form>
            </li>
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


<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">




<%--<nav class="navbar navbar-light bg-light">--%>

    <%--<form class="form-inline">--%>
        <%--<input type="text" name="query" size="30">--%>
        <%--<input type="submit" value="Search">--%>
        <%--<select name="type">--%>
            <%--<option>Race</option>--%>
            <%--<option>Horse</option>--%>
        <%--</select>--%>
    <%--</form>--%>
    <%--<form class="form-inline">--%>
        <%--<ul name="user_options">--%>
            <%--<li class="active">${login}</li>--%>
            <%--<li><a href="/controller?command=to profile">Profile</a></li>--%>
            <%--&lt;%&ndash;<option>${login}</option>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<option value="/controller?command=to profile">Profile</option>&ndash;%&gt;--%>
        <%--</ul>--%>
        <%--&lt;%&ndash;<div class="collapse navbar-collapse">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<ul class="nav navbar-nav">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li class="active"><a href="#">Main</a></li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li><a href="#">Search</a></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--</form>--%>
    <%--<form class="form-inline">--%>
        <%--<input type="hidden" name="command" value="log out">--%>
        <%--<input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Log Out"/>--%>
    <%--</form>--%>
<%--</nav>--%>
</body>
</html>
