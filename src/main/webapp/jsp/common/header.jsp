<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <link href="/css/header.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
</head>
<div>
    <nav class="navbar navbar-expand-lg fixed-top" id="up" style="background-color: dimgray">


        <ul class="navbar-nav ml-auto navbar-collapse">
            <li class="nav-item navbar-brand">
                <a href="#"><h2>WhoScored.com</h2></a>
            </li>
            <li class="nav-item navbar-brand">
                <a href="/main?command=to main"><h2>
                    <fmt:message key="main" bundle="${var}"/></h2></a>
            </li>

            <c:if test="${role eq 'admin'}">
                <li class="nav-item navbar-brand">
                    <select class="selectpicker form-control" style="background-color: dimgray; color: white"
                            onchange="location = this.value;">
                        <option value="" disabled selected>
                            <fmt:message key="header.actions" bundle="${var}"/>
                        </option>
                        <option value="/main?command=to add race">
                            <fmt:message key="header.addrace" bundle="${var}"/>
                        </option>
                        <option value="/main?command=to hold race">
                            <fmt:message key="header.holdrace" bundle="${var}"/>
                        </option>
                        <option value="/main?command=to add payment">
                            <fmt:message key="header.addpayment" bundle="${var}"/>
                        </option>
                        <option value="/main?command=to add admin">
                            <fmt:message key="header.addadmin" bundle="${var}"/>
                        </option>
                        <option value="/main?command=to add bookmaker">
                            <fmt:message key="header.addbookmaker" bundle="${var}"/>
                        </option>
                        <option value="/main?command=to add horse">
                            <fmt:message key="header.addhorse" bundle="${var}"/>
                        </option>
                        <option value="/main?command=to user list">
                            <fmt:message key="header.userlist" bundle="${var}"/>
                        </option>
                    </select>
                </li>
            </c:if>
            <c:if test="${role eq 'bookmaker'}">
                <li class="nav-item navbar-brand">
                    <select class="selectpicker form-control" style="background-color: dimgray; color: white"
                            onchange="location = this.value;">
                        <option value="" disabled selected>
                            <fmt:message key="header.actions" bundle="${var}"/>
                        </option>
                        <option value="/main?command=to add bet">
                            <fmt:message key="header.addbet" bundle="${var}"/>
                        </option>
                    </select>
                </li>
            </c:if>
            <c:if test="${role eq 'client'}">

                <li class="nav-item navbar-brand">
                    <a href="/main?command=to user bets">
                        <h2><fmt:message key="header.yourbets" bundle="${var}"/></h2></a>
                </li>
                <li class="nav-item navbar-brand">
                    <a href="/main?command=to top up balance">
                        <h2><fmt:message key="header.topup" bundle="${var}"/></h2></a>
                </li>

            </c:if>
            <li class="nav-item navbar-brand">
                <a href="/main?command=to race results">
                    <h2> <fmt:message key="header.raceresults" bundle="${var}"/></h2></a>
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
                        <input type="submit" class="btn btn-success"
                               value="<fmt:message key="header.logout" bundle="${var}"/>">
                    </form>
                </li>

            </ul>
        </div>
    </nav>
</div>

