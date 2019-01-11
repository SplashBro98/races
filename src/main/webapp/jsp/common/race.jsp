<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.race" bundle="${var}"/></title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          rel="stylesheet" id="bootstrap-css">
</head>
<body>
<c:import url="header.jsp"/>

<div class="parallax" style="height: max-content">
    <div class="overlays"></div>
    <div class="container h-100" style="margin-top: 7%">
        <div class="col-lg-12">
            <div class="text-center">

                <div class="container">
                    <div class="container-fluid" style="background-color: dimgray">
                        <div class="container container-pad colortext">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading" style="margin-bottom: 50px">
                                            <h3 class="panel-title">
                                                <fmt:message key="column.race" bundle="${var}"/> : ${race.name}</h3>
                                            <h4 class="panel-title">
                                                <fmt:message key="column.place" bundle="${var}"/> : ${race.place}</h4>
                                            <h4 class="panel-title">
                                                <fmt:message key="column.time" bundle="${var}"/> : ${race.time}</h4>
                                            <h4 class="panel-title">
                                                <fmt:message key="column.date" bundle="${var}"/> : ${race.date}</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <c:import url="horseTable.jsp"/>
                            <c:import url="betTable.jsp"/>
                        </div>
                    </div>
                    <c:import url="footer.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
