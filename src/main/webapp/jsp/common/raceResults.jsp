<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.raceResults" bundle="${var}"/></title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:import url="header.jsp"/>

<div class="parallax" style="height: max-content">
    <div class="overlays"></div>
    <div class="container h-100">
        <div class="col-lg-12 text-center">

            <div class="container colortext" style="margin-top: auto">

                <c:forEach items="${raceResults}" var="result">
                    <div class="container-fluid"
                         style="background-color:dimgray; margin-top: 10%; margin-bottom: 10%">

                        <div class="container container-pad">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                <fmt:message key="column.race" bundle="${var}"/> : ${result.race.name}</h3><br>
                                            <h4 class="panel-title">
                                                <fmt:message key="column.place" bundle="${var}"/> : ${result.race.place}</h4>
                                        </div>
                                        <table class="table table-hover">
                                            <thead class="colortext">
                                            <tr>
                                                <th><fmt:message key="column.position" bundle="${var}"/></th>
                                                <th><fmt:message key="holder.name" bundle="${var}"/></th>
                                            </tr>
                                            </thead>
                                            <tbody class="colortext">
                                            <tr>
                                                <td>1</td>
                                                <td>${result.firstHorseName}</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>${result.secondHorseName}</td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>${result.thirdHorseName}</td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>${result.fourthHorseName}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
</body>
</html>