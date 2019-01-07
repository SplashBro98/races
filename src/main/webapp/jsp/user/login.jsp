<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="label.signin" bundle="${var}"/></title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">

</head>
<body>
<c:import url="../common/withoutLoginHeader.jsp"/>

<div class="parallax wrapper" style="height: max-content">
    <div class="overlays"></div>
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center ">
            <div class="col-lg-12 text-center ">

                <div class="container">
                    <div style="margin-right: auto; margin-left: auto" class="mainbox col-md-4 col-sm-8">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <h3><fmt:message key="form.signin" bundle="${var}"/></h3></div>
                            </div>
                            <div style="padding-top:40px" class="panel-body">

                                <c:if test="${not empty incorrect}">
                                    <h6><fmt:message key="info.login" bundle="${var}"/></h6>
                                </c:if>
                                <c:if test="${not empty blocked}">
                                    <h6><fmt:message key="info.blocked" bundle="${var}"/></h6>
                                </c:if>

                                <form id="loginform" role="form" class="form-horizontal" action="/main"
                                      method="post">
                                    <input type="hidden" name="command" value="log in">
                                    <input type="hidden" name="locale" value="${locale}">

                                    <div style="margin-bottom: 25px" class="form-group">
                                        <input id="login-username" type="text"
                                               class="form-control"
                                               name="login"
                                               placeholder="<fmt:message key="holder.login" bundle="${var}"/>* (не больше 30 символов)"
                                               pattern="[a-zA-Z0-9А-Яа-я_`-]{4,30}" required>
                                    </div>

                                    <div style="margin-bottom: 25px" class="form-group">
                                        <input id="login-password" type="password" class="form-control"
                                               name="password"
                                               pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}"
                                               placeholder="<fmt:message key="holder.password" bundle="${var}"/>* (должен содержать не меньше 6 символов, цифру, прописную и строчную буквы"
                                               required>
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
</div>


</body>
</html>
