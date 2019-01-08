<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.signup" bundle="${var}"/></title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
</head>
<body>

<c:import url="../../common/withoutLoginHeader.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div>
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <%--Sign up form--%>
                    <div class="container">
                        <div id="signupbox" style="margin-right: auto; margin-left: auto"
                             class="mainbox col-md-8  col-sm-8">
                            <div class="panel panel-info">
                                <div class="panel-heading" style="margin-bottom: 40px">
                                    <div class="panel-title text-center">
                                        <h3><fmt:message key="signupform" bundle="${var}"/></h3></div>
                                </div>
                                <div class="panel-body">
                                    <form id="signupform">
                                        <input type="hidden" name="command" value="sign up">


                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="text" class="form-control" name="name"
                                                   pattern="[A-Za-zА-Яа-я -]{1,30}" value="${name}"
                                                   placeholder="<fmt:message key="holder.name" bundle="${var}"/>*"
                                                   required>
                                            <div class="text-center">${incorrect_name}</div>
                                        </label>


                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="text" class="form-control" name="surname"
                                                   pattern="[A-Za-zА-Яа-я -]{1,30}" value="${surname}"
                                                   placeholder="<fmt:message key="holder.surname" bundle="${var}"/>*"
                                                   required>
                                            ${incorrect_surname}
                                        </label>


                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="text" class="form-control" name="login"
                                                   pattern="[a-zA-Z0-9А-Яа-я_`]{4,40}" value="${login}"
                                                   placeholder="<fmt:message key="holder.login" bundle="${var}"/>*"
                                                   required>
                                            ${incorrect_login}
                                        </label>


                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="password" class="form-control" name="password"
                                                   pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}"
                                                   placeholder="<fmt:message key="holder.password" bundle="${var}"/>*"
                                                   value="${password}" required>
                                            ${incorrect_password}
                                        </label>

                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="password" class="form-control"
                                                   name="confirmedPassword"
                                                   pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}"
                                                   placeholder="<fmt:message key="holder.confirmPassword" bundle="${var}"/>*"
                                                   value="${confirmedPassword}"
                                                   required>
                                            ${not_confirmed}
                                        </label>

                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="email" class="form-control" name="email"
                                                   placeholder="<fmt:message key="holder.email" bundle="${var}"/>*"
                                                   value="${email}"
                                                   required>
                                            ${incorrect_email}
                                        </label>

                                        <div style="margin-top:10px" class="form-group">
                                            <!-- Button -->
                                            <div class="col-md-12">
                                                <input type="submit" class="btn btn-success"
                                                       value="<fmt:message key="signup" bundle="${var}"/>">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                                                    <a href="/main?command=to log in">
                                                        <fmt:message key="signin" bundle="${var}"/>
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


</body>
</html>
