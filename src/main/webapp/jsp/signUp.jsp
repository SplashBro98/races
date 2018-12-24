<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 18.11.2018
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title>SignUp_JSP</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <link href="/css/login.css" rel="stylesheet" type="text/css">
    <link href="/css/header.css" rel="stylesheet" type="text/css">

    <link href="/vendors/jquery/jquery.min.js">
    <link href="/vendors/jquery/jquery-1.11.1.min.js">
    <link href="/vendors/bootstrap/js/bootstrap.min.js">

</head>
<body>

<c:import url="withoutLoginHeader.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <%--Sign up form--%>
                    <div class="container">
                        <div id="signupbox" style="margin-right: auto; margin-left: auto"
                             class="mainbox col-md-8  col-sm-8">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <div class="panel-title">Sign Up Form</div>
                                </div>
                                <div class="panel-body">
                                    <form id="signupform">
                                        <input type="hidden" name="command" value="sign up">

                                        <label class="col-md-6 control-label">First Name:

                                            <input type="text" class="form-control" name="name"
                                                   pattern="[A-Za-zА-Яа-я ]{1,30}" value="${name}"
                                                   placeholder="First Name" required>
                                        </label>

                                        <label class="col-md-6 control-label">Last Name:
                                            <input type="text" class="form-control" name="surname"
                                                   pattern="[A-Za-zА-Яа-я -]{1,30}" value="${surname}"
                                                   placeholder="Last Name" required>
                                        </label>

                                        <label class="col-md-6 control-label">Login:
                                            <input type="text" class="form-control" name="login"
                                                   pattern="[a-zA-Z0-9А-Яа-я_`]{4,30}" value="${login}"
                                                   placeholder="Login" required>
                                            ${incorrect_login}
                                        </label>


                                        <label class="col-md-6 control-label">Password:
                                            <input type="password" class="form-control" name="password"
                                                   pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}"
                                                   placeholder="Password" required>
                                        </label>
                                        <label class="col-md-6 control-label">ConfirmPassword:
                                            <input type="password" class="form-control" name="confirmedPassword"
                                                   pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}"
                                                   placeholder="Password" value="${confirmedPassword}" required>
                                        </label>
                                        <label class="col-md-6 control-label">Email:
                                            <input type="email" class="form-control" name="email"
                                                   placeholder="Email Address" value="${email}"
                                                   required>
                                        </label>

                                        <div style="margin-top:10px" class="form-group">
                                            <!-- Button -->
                                            <div class="col-md-12">
                                                <input type="submit" class="btn btn-success" value="Sign Up">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                                                    <a href="/main?command=to log in">
                                                        Sign In
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
    </div>
</section>

<%--<div class="form-style-2">--%>
<%--<form action="main" method="post">--%>
<%--<input type="hidden" name="command" value="sign up">--%>
<%--<label>Enter name:--%>
<%--<input type="text" name="name" required/>--%>
<%--</label>--%>
<%--<label>Enter surname:--%>
<%--<input type="text" name="surname" required/>--%>
<%--</label>--%>
<%--<label>Enter your login:--%>
<%--<input type="text" name="login" required/> ${incorrect_login}--%>
<%--</label>--%>
<%--<label>Enter your password:--%>
<%--<input type="password" name="password" required/>--%>
<%--</label>--%>
<%--<label>Enter your email:--%>
<%--<input type="email" name="email" required/>--%>
<%--</label>--%>
<%--<label>Your type:--%>
<%--<input type="text" name="userType" required/>--%>
<%--</label>--%>
<%--<input type="submit" value="SignUp">--%>
<%--</form>--%>
<%--</div>--%>


</body>
</html>
