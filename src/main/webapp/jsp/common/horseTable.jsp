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

<div class="row">
    <div class="col-md-12">
        <div class="panel panel-primary">
            <div class="panel-heading" style="margin-bottom: 30px">
                <h3 class="panel-title"><fmt:message key="list.horses" bundle="${var}"/></h3>
            </div>
            <table class="table table-hover" id="dev-table">
                <thead style="color: white">
                <tr>
                    <th>#</th>
                    <th><fmt:message key="holder.firstname" bundle="${var}"/></th>
                    <th><fmt:message key="column.age" bundle="${var}"/></th>
                    <th><fmt:message key="column.wins" bundle="${var}"/></th>
                </tr>
                </thead>
                <tbody style="color: white">
                <c:forEach items="${horses}" var="horse" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${horse.name}</td>
                        <td>${horse.age}</td>
                        <td>${horse.wins}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
