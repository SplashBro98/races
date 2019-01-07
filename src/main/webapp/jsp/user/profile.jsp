<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="salah" uri="liverpool" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>

<html>
<head>
    <title><fmt:message key="label.profile" bundle="${var}"/></title>
    <link href="/css/profile.css" rel="stylesheet" type="text/css">
    <link href="/css/main.css" rel="stylesheet" type="text/css">

</head>
<body>
<c:import url="../common/header.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div>
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6"
                                 style="margin-left: auto; margin-right: auto">
                                <div class="card" style="background-color: dimgray; margin-top: 50px">
                                    <div class="card-body">
                                        <h4 class="card-title"><fmt:message key="yourprofile" bundle="${var}"/></h4>
                                        <table class="table table-user-information">
                                            <tbody class="colortext">
                                            <tr>
                                                <td><fmt:message key="holder.name" bundle="${var}"/>:</td>
                                                <td>${user.name}</td>
                                            </tr>
                                            <tr>
                                                <td><fmt:message key="holder.surname" bundle="${var}"/>:</td>
                                                <td>${user.surname}</td>
                                            </tr>
                                            <tr>
                                                <td><fmt:message key="holder.login" bundle="${var}"/>:</td>
                                                <td>${user.login}</td>
                                            </tr>
                                            <tr>
                                                <td><fmt:message key="holder.email" bundle="${var}"/>:</td>
                                                <td>${user.email}</td>
                                            </tr>
                                            <c:if test="${role eq 'client'}">
                                                <tr>
                                                    <td><fmt:message key="holder.amount" bundle="${var}"/>:</td>
                                                    <td>${user.amount} $</td>
                                                </tr>
                                            </c:if>
                                            <tr>
                                                <td><fmt:message key="holder.role" bundle="${var}"/>:</td>
                                                <td>${role}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                        <c:if test="${role eq 'client'}">
                                            <a href="/main?command=to edit profile" class="btn btn-primary">
                                                <fmt:message key="button.editprofile" bundle="${var}"/></a>
                                        </c:if>
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

<c:import url="../common/footer.jsp"/>


</body>
</html>
