<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.addAdmin" bundle="${var}"/></title>

</head>
<body>

<c:import url="../../common/header.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div>
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">

                    <div class="container">
                        <div style="margin-right: auto; margin-left: auto"
                             class="mainbox col-md-8  col-sm-8">
                            <div class="panel panel-info">
                                <div class="panel-heading" style="margin-bottom: 40px">
                                    <div class="panel-title text-center">
                                        <h3><fmt:message key="form.addadmin" bundle="${var}"/></h3></div>
                                </div>
                                <div class="panel-body">
                                    <form action="/main" method="post">
                                        <input type="hidden" name="command" value="add admin">


                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="text" class="form-control" name="login"
                                                   pattern="[a-zA-Z0-9А-Яа-я_`]{4,30}" value="${admin_login}"
                                                   placeholder="<fmt:message key="holder.login" bundle="${var}"/>*"
                                                   oninvalid="this.setCustomValidity('<fmt:message key="info.incorrectlogin"
                                                                                                   bundle="${var}"/>')"
                                                   oninput="this.setCustomValidity('')"
                                                   required>
                                            <c:if test="${not empty incorrect_login}">
                                                <fmt:message key="incorrect.login" bundle="${var}"/>
                                            </c:if>
                                        </label>


                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="password" class="form-control" name="password"
                                                   pattern="(?=.*[0-9])(?=.*[a-z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}"
                                                   placeholder="<fmt:message key="holder.password" bundle="${var}"/>*"
                                                   value="${password}"
                                                   oninvalid="this.setCustomValidity('<fmt:message key="info.incpasswordformat"
                                                                                                   bundle="${var}"/>')"
                                                   oninput="this.setCustomValidity('')"
                                                   required>
                                            <c:if test="${not empty incorrect_password}">
                                                <fmt:message key="incorrect.password" bundle="${var}"/>
                                            </c:if>
                                        </label>

                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="password" class="form-control"
                                                   name="confirmedPassword"
                                                   pattern="(?=.*[0-9])(?=.*[a-z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}"
                                                   placeholder="<fmt:message key="holder.confirmPassword" bundle="${var}"/>*"
                                                   value="${confirmedPassword}" required>
                                            <c:if test="${not empty not_confirmed}">
                                                <fmt:message key="incorrect.password" bundle="${var}"/>
                                            </c:if>
                                        </label>

                                        <label class="col-md-6 control-label" style="margin-bottom: 15px">
                                            <input type="email" class="form-control" name="email"
                                                   placeholder="<fmt:message key="holder.email" bundle="${var}"/>*"
                                                   value="${email}"
                                                   required>
                                            <c:if test="${not empty incorrect_email}">
                                                <fmt:message key="incorrect.email" bundle="${var}"/>
                                            </c:if>
                                        </label>

                                        <div style="margin-top:10px" class="form-group">
                                            <div class="col-md-12">
                                                <input type="submit" class="btn btn-success"
                                                       value="<fmt:message key="button.addadmin" bundle="${var}"/>">
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <c:import url="../../common/footer.jsp"/>
            </div>
        </div>
    </div>
</section>



</body>
</html>
