<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 13.12.2018
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
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
            <div class="col-lg-12 text-center">

                <div class="container" style="margin-top: auto">
                    <div class="container-fluid" style="background-color: dimgray">
                        <div class="container container-pad" style="margin-top: 30%">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading" style="margin-bottom: 30px; margin-top: auto">
                                            <h2 class="panel-title"><fmt:message key="list.users" bundle="${var}"/></h2>
                                        </div>
                                        <table class="table table-hover" id="dev-table">
                                            <thead style="color: white">
                                            <tr>
                                                <th>#</th>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Login</th>
                                                <th>Email</th>
                                                <th>Amount</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>
                                            <tbody style="color: white">
                                            <c:forEach items="${users}" var="user" varStatus="counter">
                                                <tr>
                                                    <td>${counter.count}</td>
                                                    <td>${user.name}</td>
                                                    <td>${user.surname}</td>
                                                    <td>${user.login}</td>
                                                    <td>${user.email}</td>
                                                    <td>${user.amount}</td>
                                                    <c:choose>
                                                        <c:when test="${user.isLocked eq false}">
                                                            <td>
                                                                <button class="btn btn-primary" data-toggle="modal">
                                                                    <a href="/main?command=block user&userLogin=${user.login}"
                                                                       style="color: white">
                                                                        <fmt:message key="button.block"
                                                                                     bundle="${var}"/></a>
                                                                </button>
                                                            </td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td>
                                                                <button class="btn btn-success" data-toggle="modal">
                                                                    <a href="/main?command=unlock user&userLogin=${user.login}"
                                                                       style="color: white">
                                                                        <fmt:message key="button.unlock"
                                                                                     bundle="${var}"/></a>
                                                                </button>
                                                            </td>

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
                </div>
            </div>
        </div>
    </div>
</section>


<c:import url="../../common/footer.jsp"/>
</body>
</html>