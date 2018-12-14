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
    <title>Login_JSP</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <link href="/css/login.css" rel="stylesheet" type="text/css">
    <link href="/css/start.css" rel="stylesheet" type="text/css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<c:import url="withoutLoginHeader.jsp"/>


<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <%--login form--%>
                    <div class="container">
                        <div id="loginbox" style="margin-top:120px; margin-left: 30%" class="mainbox col-md-4 col-sm-8">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <div class="panel-title"><h3>Sign In Form</h3></div>
                                </div>

                                <div style="padding-top:40px" class="panel-body">

                                    <div style="display:none" id="login-alert"
                                         class="alert alert-danger col-sm-12"></div>

                                    <h6>${incorrect}</h6>
                                    <form id="loginform" class="form-horizontal" action="/main" method="post">
                                        <input type="hidden" name="command" value="log in">

                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-user"></i></span>
                                            <input id="login-username" type="text" class="form-control" name="login"
                                                   placeholder="Login" >
                                        </div>

                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                            <input id="login-password" type="password" class="form-control"
                                                   name="password"
                                                   placeholder="Password">
                                        </div>

                                        <div style="margin-top:10px" class="form-group">
                                            <!-- Button -->
                                            <div class="col-md-12 controls">
                                                <input type="submit" class="btn btn-success" value="Sign In">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-md-12 control">
                                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                                                    Don't have an account!
                                                    <a href="/main?command=to sign up">
                                                        Sign Up Here
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

<script>
    $(document).ready(function () {

        $('loginform').validate({
            rules: {
                login: {
                    minlength: 4,
                    required: true
                },
                password: {
                    minlength: 8,
                    maxlength: 25,
                    required: true
                }
            },
            highlight: function (element) {
                $(element).closest('.control-group').removeClass('success').addClass('error');
            },
            success: function (element) {
                element.text('OK!').addClass('valid')
                    .closest('.control-group').removeClass('error').addClass('success');
            }
        });
    });
</script>

</body>
</html>
