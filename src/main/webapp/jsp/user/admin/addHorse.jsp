<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.addHorse" bundle="${var}"/></title>

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
                        <div style="margin-right: auto; margin-left: auto;"
                             class="mainbox col-md-4  col-sm-8">
                            <div class="panel panel-info">
                                <div class="panel-heading" style="margin-bottom: 40px">
                                    <div class="panel-title text-center">
                                        <h3><fmt:message key="form.addhorse" bundle="${var}"/></h3></div>
                                </div>
                                <div class="panel-body">
                                    <form action="/main" method="post">
                                        <input type="hidden" name="command" value="add horse">

                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-user"></i></span>
                                            <input type="text" class="form-control" name="name" value="${name}"
                                                   pattern="[a-zA-Z0-9А-Яа-я_ -]{4,30}"
                                                   placeholder="<fmt:message key="holder.name" bundle="${var}"/>*"
                                                   required>
                                            <c:if test="${not empty incorrect_name}">
                                                <fmt:message key="incorrect.name" bundle="${var}"/>
                                            </c:if>
                                        </div>

                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                            <input type="text" class="form-control"
                                                   name="age" pattern="^[0-9]+$"
                                                   placeholder="<fmt:message key="holder.age" bundle="${var}"/>*"
                                                   required>
                                            <c:if test="${not empty incorrect_age}">
                                                <fmt:message key="incorrect.age" bundle="${var}"/>
                                            </c:if>
                                        </div>



                                        <div style="margin-top:10px" class="form-group">
                                            <div class="col-md-12 controls">
                                                <input type="submit" class="btn btn-success"
                                                       value="<fmt:message key="button.addhorse" bundle="${var}"/>">
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

