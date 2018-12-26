<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 05.12.2018
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title>Header</title>

    <link href="/css/header.css" rel="stylesheet" type="text/css">
    <%--<link href="/vendors/bootstrap/js/bootstrap.min.js">--%>
    <%--<link href="/vendors/jquery/jquery.min.js">--%>
    <%--<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>--%>
    <%--<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
</head>
<div>
    <nav class="navbar navbar-expand-lg fixed-top" id="up" style="background-color: dimgray">


        <ul class="navbar-nav ml-auto navbar-collapse">
            <li class="nav-item navbar-brand">
                <a href="#"><h2><fmt:message key="title" bundle="${var}"/></h2></a>
            </li>
            <li class="nav-item navbar-brand">
                <a href="/main?command=to main"><h2>
                    <fmt:message key="main" bundle="${var}"/></h2></a>
            </li>
            <li class="nav-item navbar-brand">
                <div class="dropdown">
                    <button class="btn btn-success dropdown-toggle" type="button"
                            id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                        Actions
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <c:choose>
                            <c:when test="${role eq 'admin'}">
                                <a class="dropdown-item" href="/main?command=to add race"><h4>Add Race</h4></a>
                                <a class="divider"></a>
                                <a class="dropdown-item" href="#"><h4>Enter Results</h4></a>
                            </c:when>
                            <c:when test="${role eq 'bookmaker'}">
                                <a class="dropdown-item" href="/main?command=to add bet"><h4>Add Bet</h4></a>
                                <a class="divider"></a>
                            </c:when>


                        </c:choose>
                    </div>
                </div>
                <%--<div class="btn-group">--%>
                    <%--<a data-toggle="dropdown" href="/main?command=to add race">--%>
                        <%--<h2><fmt:message key="header.actions" bundle="${var}"/></h2>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<c:choose>--%>
                            <%--<c:when test="${role eq 'admin'}">--%>
                                <%--<li><a href="/main?command=to add race"><h3>Add Race</h3></a></li>--%>
                                <%--<li class="divider"></li>--%>
                                <%--<li><a href="/main?command=to add race"><h3>Enter Results</h3></a></li>--%>
                            <%--</c:when>--%>
                            <%--<c:when test="${role eq 'bookmaker'}">--%>
                                <%--<li><a href="/main?command=to add bet"><h3>Add Bet</h3></a></li>--%>
                                <%--<li class="divider"></li>--%>
                            <%--</c:when>--%>
                        <%--</c:choose>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            </li>
        </ul>


        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/main?command=to profile">${login}
                        <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <form>
                        <input type="hidden" name="command" value="log out">
                        <input type="submit" class="btn btn-success" value=<fmt:message key="header.logout"
                                                                                        bundle="${var}"/>>
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
</div>

