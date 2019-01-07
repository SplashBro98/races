<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title><fmt:message key="label.addRace" bundle="${var}"/></title>

    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link href="/vendors/bootstrap/css/bootstrap_main.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          rel="stylesheet" id="bootstrap-css">
</head>
<body>
<c:import url="../../common/header.jsp"/>
<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <div class="container">
                        <div class="container-fluid" style="background-color: dimgray; margin-bottom: 10%">

                            <div class="container container-pad" style="margin-top: 10%">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="panel panel-primary">
                                            <div class="panel-heading" style="margin-bottom: 30px">
                                                <h3 class="panel-title"><fmt:message key="list.userbets"
                                                                                     bundle="${var}"/></h3>
                                            </div>
                                            <table class="table table-hover">
                                                <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Race Name</th>
                                                    <th>Horse Name</th>
                                                    <th>Position</th>
                                                    <th>Coefficient</th>
                                                    <th>Sum of the Bet</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${currentUserBets}" var="userBet" varStatus="counter">

                                                    <input type="hidden" name="raceName" value="${race.raceId}">
                                                    <tr>
                                                        <td>${counter.count}</td>
                                                        <td>
                                                            <a href="/main?command=select race&name=${userBet.getRace().getName()}"
                                                               target="_parent">${userBet.getRace().getName()}</a></td>
                                                        <td>${userBet.getHorse().getName()}</td>
                                                        <td>${userBet.getPosition()}</td>
                                                        <td>${userBet.getCoeff()}</td>
                                                        <td>${userBet.getSum()}</td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                            <div style="color: white">
                                                <h2>${nothing}</h2>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <c:if test="${ not empty previousUserBets}">
                            <div class="container-fluid" style="background-color: dimgray; margin-bottom: 10%">

                                <div class="container container-pad" style="margin-top: 10%">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="panel panel-primary">
                                                <div class="panel-heading" style="margin-bottom: 30px">
                                                    <h3 class="panel-title"><fmt:message key="list.userbets"
                                                                                         bundle="${var}"/></h3>
                                                </div>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Race Name</th>
                                                        <th>Horse Name</th>
                                                        <th>Position</th>
                                                        <th>Coefficient</th>
                                                        <th>Sum of the Bet</th>
                                                        <th>Result</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${previousUserBets}" var="userBet"
                                                               varStatus="counter">
                                                        <input type="hidden" name="raceName" value="${race.raceId}">
                                                        <tr>
                                                            <td>${counter.count}</td>
                                                            <td>
                                                                <a href="/main?command=select race&name=${userBet.getRace().getName()}"
                                                                   target="_parent">${userBet.getRace().getName()}</a>
                                                            </td>
                                                            <td>${userBet.getHorse().getName()}</td>
                                                            <td>${userBet.getPosition()}</td>
                                                            <td>${userBet.getCoeff()}</td>
                                                            <td>${userBet.getSum()}</td>
                                                            <c:choose>
                                                                <c:when test="${userBet.isSuccessful() eq true}">
                                                                    <td>Successful</td>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <td>Not Successful</td>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<c:import url="../../common/footer.jsp"/>
</body>
</html>