<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="salah" uri="liverpool" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>

<html>
<head>
    <title>Profile</title>
    <link href="/css/profile.css" rel="stylesheet" type="text/css">
    <%--<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>--%>
    <%--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
    <link href="/vendors/jquery/jquery-1.11.1.min.js">
    <link href="/vendors/jquery/jquery.min.js">
    <link href="/vendors/bootstrap/js/bootstrap.min.js">
    <link href="/vendors/bootstrap/css/bootstrap_main.min.css">

</head>
<body>

<c:import url="header.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100" style="margin-top: 50px; color: white">
        <div class="container">
            <div class="panel panel-info" style="margin-top: 10px">

                <div class="panel-body">
                    <div class="row">
                        <div class="text-center">
                            <div class=" col-md-9">
                                <table class="table table-user-information">
                                    <tbody class="colortext">
                                    <tr>
                                        <td>Name:</td>
                                        <td> ${user.name} ${user.surname}</td>
                                    </tr>
                                    <tr>
                                        <td>Login:</td>
                                        <td>${user.login}</td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td>${user.email}</td>
                                    </tr>

                                    <tr>
                                    </tbody>
                                </table>


                                <a href="/main?command=edit profile" class="btn btn-primary">Edit Profile</a>
                            </div>
                        </div>
                    </div>
                </div>
                <c:import url="userBetTable.jsp"/>
            </div>
        </div>
    </div>
</section>

<c:import url="footer.jsp"/>


</body>
</html>
