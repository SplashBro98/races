<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 01.11.2018
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="label.signin" bundle="${var}"/> </title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-cs">
    <link href="/css/login.css" rel="stylesheet" type="text/css">

    <link href="/vendors/jquery/jquery.min.js">
    <link href="/vendors/jquery/jquery-1.11.1.min.js">
    <link href="/vendors/bootstrap/js/bootstrap.min.js">

</head>
<body>
<c:import url="withoutLoginHeader.jsp"/>


<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="row h-100 justify-content-between align-items-center">
        <div class="col-lg-12">
            <div class="text-center">
                <%--login form--%>
                <div class="container">
                    <div id="loginbox"  style="margin-right: auto; margin-left: auto" class="mainbox col-md-4 col-sm-8">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <h3><fmt:message key="form.signin" bundle="${var}"/> </h3></div>
                            </div>

                            <div style="padding-top:40px" class="panel-body">

                                <h6>${incorrect}</h6>
                                <form id="loginform" role="form" class="form-horizontal" action="/main"
                                      method="post">
                                    <input type="hidden" name="command" value="log in">

                                    <div style="margin-bottom: 25px" class="form-group">

                                        <input id="login-username" type="text"
                                               class="form-control" oninvalid="InvalidMsg(this);"
                                               name="login" placeholder="Login"
                                               pattern="[a-zA-Z0-9А-Яа-я_`-]{4,30}" required>
                                    </div>

                                    <div style="margin-bottom: 25px" class="form-group">
                                        <input id="login-password" type="password" class="form-control"
                                               name="password"
                                               pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}"
                                               placeholder="Password" required>
                                    </div>

                                    <div style="margin-top:10px" class="form-group">
                                        <!-- Button -->
                                        <div class="col-md-12 controls">
                                            <input type="submit" class="btn btn-success"
                                                   value="<fmt:message key="label.signin" bundle="${var}"/>">
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <div class="col-md-12 control">
                                            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                                                <fmt:message key="form.describe" bundle="${var}"/>
                                                <a href="/main?command=to sign up">
                                                    <fmt:message key="form.signuphere" bundle="${var}"/>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

</section>

</body>
</html>
