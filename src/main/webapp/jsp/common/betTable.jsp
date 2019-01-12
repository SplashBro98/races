<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          rel="stylesheet" id="bootstrap-css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading" style="margin-bottom: 30px">
                    <h3 class="panel-title"><fmt:message key="list.bets" bundle="${var}"/></h3>
                </div>
                <table class="table table-hover">
                    <thead style="color: white">
                    <tr>
                        <th>#</th>
                        <th><fmt:message key="holder.firstname" bundle="${var}"/></th>
                        <th><fmt:message key="holder.position" bundle="${var}"/></th>
                        <th><fmt:message key="holder.coeff" bundle="${var}"/></th>
                        <c:if test="${role ne 'admin'}">
                            <th><fmt:message key="holder.action" bundle="${var}"/></th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody style="color: white">
                    <c:forEach items="${bets}" var="bet" varStatus="counter">


                        <tr>
                            <td>${counter.count}</td>
                            <td>${bet.horse.name}</td>
                            <td>${bet.position}</td>
                            <td>${bet.coeff}</td>
                            <c:if test="${role eq 'client'}">
                                <td>

                                    <button class="btn btn-success" data-toggle="modal">
                                        <a href="/main?command=to enter sum&betId=${bet.betId}&coeff=${bet.coeff}"
                                           style="color: white">
                                            <fmt:message key="button.makebet" bundle="${var}"/></a>
                                    </button>
                                </td>
                            </c:if>
                            <c:if test="${role eq 'bookmaker'}">
                                <td>

                                    <button class="btn btn-success" data-toggle="modal">
                                        <a href="/main?command=to edit bet&betId=${bet.betId}" style="color: white">
                                            <fmt:message key="button.editbet" bundle="${var}"/></a>
                                    </button>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <c:if test="${empty bets}">
                    <fmt:message key="info.nobets" bundle="${var}"/>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
