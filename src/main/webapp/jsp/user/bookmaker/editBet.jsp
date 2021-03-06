<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.editbet" bundle="${var}"/></title>
</head>
<body>
<c:import url="../../common/header.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div>
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12 text-center">

                <div class="container">
                    <div style="margin-right: auto; margin-left: auto"
                         class="mainbox col-md-4  col-sm-4">
                        <div class="panel panel-info">
                            <div class="panel-heading" style="color: white">
                                <div class="panel-title"><h3><fmt:message key="form.editbet" bundle="${var}"/></h3>
                                </div>
                            </div>
                            <div style="padding-top:40px" class="panel-body">

                                <div style="display:none" id="login-alert"
                                     class="alert alert-danger col-sm-12"></div>

                                <form class="form-horizontal" action="/main" method="post">
                                    <input type="hidden" name="command" value="edit bet">

                                    <div style="margin-bottom: 25px" class="control-group">
                                        <input type="text" class="form-control"
                                               name="raceName" value="${bet.race.name}"
                                               required readonly>
                                    </div>

                                    <div style="margin-bottom: 25px" class="control-group">
                                        <input type="text" class="form-control"
                                               name="horseName" value="${bet.horse.name}"
                                               required readonly>
                                    </div>

                                    <div style="margin-bottom: 25px" class="control-group">
                                        <input type="text" class="form-control"
                                               name="position" value="${bet.position}"
                                               required readonly>
                                    </div>

                                    <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                        <input type="text" class="form-control"
                                               name="coeff" pattern="^((?!0\.00)(0[.,]\d{2}|([1-9]\d{0,5})([.,]\d{2})?))$"
                                               placeholder="Coefficient*" value="${bet.coeff}" required>
                                        <c:if test="${not empty incorrect_coeff}">
                                            <fmt:message key="incorrect.coeff" bundle="${var}"/>
                                        </c:if>
                                    </div>


                                    <div style="margin-top:10px" class="form-group">
                                        <div class="col-md-12 controls">
                                            <input type="submit" class="btn btn-success"
                                                   value="<fmt:message key="button.savechanges" bundle="${var}"/>">
                                        </div>
                                    </div>

                                </form>
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
