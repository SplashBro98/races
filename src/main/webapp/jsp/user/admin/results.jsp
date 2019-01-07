<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.ho" bundle="${var}"/></title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">

</head>
<body>
<c:import url="../../common/header.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12 text-center">
                <div class="container" style="margin-top: auto">
                    <div class="container-fluid" style="background-color:dimgray; margin-top: 10%">
                        <div class="container container-pad">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                <fmt:message key="raceresults" bundle="${var}"/> "${raceName}"</h3>
                                        </div>
                                        <table class="table table-hover">
                                            <thead class="colortext">
                                            <tr>
                                                <th><fmt:message key="holder.position" bundle="${var}"/></th>
                                                <th><fmt:message key="holder.name" bundle="${var}"/></th>
                                            </tr>
                                            </thead>
                                            <tbody class="colortext">
                                            <c:forEach items="${horses}" var="horse" varStatus="counter">
                                                <tr>
                                                    <td>${counter.count}</td>
                                                    <td>${horse.name}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<c:import url="../../common/footer.jsp"/>

</body>
</html>