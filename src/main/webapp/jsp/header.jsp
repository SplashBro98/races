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

            <c:if test="${role eq 'admin'}">
                <li class="nav-item navbar-brand dropdown thumb-dropdown">
                    <a href="#" class="dropdown-toggle"
                       data-toggle="dropdown">Actions <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="#">
                                Preview carousel indicators
                            </a>
                        </li>
                    </ul>

                        <%--<button class="btn btn-success dropdown-toggle" type="button"--%>
                                <%--data-toggle="dropdown" aria-expanded="false">--%>
                            <%--Actions--%>
                        <%--</button>--%>
                        <%--<a class="dropdown-item" href="/main?command=to add race"><h4>Add Race</h4></a>--%>
                        <%--<a class="divider"></a>--%>
                        <%--<a class="dropdown-item" href="/main?command=to hold race"><h4>Hold Horse Race</h4></a>--%>
                        <%--<a class="divider"></a>--%>
                        <%--<a class="dropdown-item" href="/main?command=to add payment"><h4>Add Payment</h4></a>--%>

                </li>
            </c:if>
            <c:if test="${role eq 'bookmaker'}">
                <li class="nav-item navbar-brand">
                    <div class="dropdown">
                        <button class="btn btn-success dropdown-toggle" type="button"
                                data-toggle="dropdown" aria-expanded="false">
                            Actions
                        </button>
                        <a class="dropdown-item" href="/main?command=to add bet"><h4>Add Bet</h4></a>
                    </div>
                </li>
            </c:if>
            <c:if test="${role eq 'client'}">

                <li class="nav-item navbar-brand">
                    <a href="/main?command=to user bets"><h2>
                        Your Bets</h2></a>
                </li>
                <li class="nav-item navbar-brand">
                    <a href="/main?command=top up balance"><h2>
                        Top up the balance</h2></a>
                </li>

            </c:if>
        </ul>

        <%--<li class="dropdown thumb-dropdown">--%>
            <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">My Snippets <span class="caret"></span></a>--%>
            <%--<ul class="dropdown-menu" role="menu">--%>
                <%--<li role="presentation" class="dropdown-header">Simple thumbnail</li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--Preview carousel indicators--%>
                        <%--<div class="thumbnail">--%>
                            <%--<img class="img-responsive" src="http://krowdly.co/snippets/thumbnails/1.jpg">--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--Simple subscribe form--%>
                        <%--<div class="thumbnail">--%>
                            <%--<img class="img-responsive" src="http://krowdly.co/snippets/thumbnails/2.jpg">--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--Flat user profile--%>
                        <%--<div class="thumbnail">--%>
                            <%--<img class="img-responsive" src="http://krowdly.co/snippets/thumbnails/3.jpg">--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li role="presentation" class="dropdown-header">Thumbnail with caption</li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--Discount labels--%>
                        <%--<div class="thumbnail">--%>
                            <%--<img class="img-responsive" src="http://krowdly.co/snippets/thumbnails/4.jpg">--%>
                            <%--<div class="caption">--%>
                                <%--<p>You can add any text for describe thumbnail here.</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</li>--%>


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

