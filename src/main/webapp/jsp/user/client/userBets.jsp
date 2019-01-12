<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.userbets" bundle="${var}"/></title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">

</head>
<body>
<c:import url="../../common/header.jsp"/>
<div class="parallax" style="height: max-content">
    <div class="overlays"></div>
    <div class="container h-100">
        <div class="col-lg-12 text-center">

            <div class="container colortext" style="margin-top: auto">
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
                                            <th><fmt:message key="column.racename" bundle="${var}"/></th>
                                            <th><fmt:message key="column.horsename" bundle="${var}"/></th>
                                            <th><fmt:message key="column.position" bundle="${var}"/></th>
                                            <th><fmt:message key="column.coeff" bundle="${var}"/></th>
                                            <th><fmt:message key="column.sum" bundle="${var}"/></th>
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
                                        <c:if test="${not empty nothing}">
                                            <h4><fmt:message key="info.nothing" bundle="${var}"/></h4>
                                        </c:if>
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
                                            <h3 class="panel-title"><fmt:message key="list.prevbets"
                                                                                 bundle="${var}"/></h3>
                                        </div>
                                        <table class="table table-hover">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th><fmt:message key="column.racename" bundle="${var}"/></th>
                                                <th><fmt:message key="column.horsename" bundle="${var}"/></th>
                                                <th><fmt:message key="column.position" bundle="${var}"/></th>
                                                <th><fmt:message key="column.coeff" bundle="${var}"/></th>
                                                <th><fmt:message key="column.sum" bundle="${var}"/></th>
                                                <th><fmt:message key="column.result" bundle="${var}"/></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${previousUserBets}" var="userBet"
                                                       varStatus="counter">
                                                <input type="hidden" name="raceName" value="${race.raceId}">
                                                <tr>
                                                    <td>${counter.count}</td>
                                                    <td>
                                                        ${userBet.getRace().getName()}
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
                <c:import url="../../common/footer.jsp"/>
            </div>
        </div>
    </div>
</div>



</body>
</html>