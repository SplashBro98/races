<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.addRace" bundle="${var}"/></title>

</head>
<body>
<c:import url="../../common/header.jsp"/>

<div class="parallax" style="height: max-content">
    <div class="overlays"></div>
    <div class="container h-100" style="margin-top: 7%">
        <div class="col-lg-12">
            <div class="text-center">

                <div class="container ">
                    <div style="margin-right: auto; margin-left: auto;"
                         class="mainbox col-md-4  col-sm-8">
                        <div class="panel panel-info">
                            <div class="panel-heading" style="margin-bottom: 40px">
                                <div class="panel-title text-center">
                                    <h3 style="color: white"><fmt:message key="form.addrace" bundle="${var}"/></h3>
                                </div>
                            </div>
                            <div class="panel-body">
                                <form action="/main" method="post">
                                    <input type="hidden" name="command" value="add race">

                                    <div style="margin-bottom: 25px" class="control-group colortext">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-user"></i></span>
                                        <input type="text" class="form-control" name="name" value="${name}"
                                               pattern="[a-zA-Z0-9А-Яа-я_ -]{4,30}"
                                               placeholder="<fmt:message key="holder.name" bundle="${var}"/>*"
                                               required>
                                        <c:if test="${not empty incorrect_name}">
                                            <fmt:message key="incorrect.name" bundle="${var}"/>
                                        </c:if>
                                        <c:if test="${not empty present_name}">
                                            <fmt:message key="present.name" bundle="${var}"/>
                                        </c:if>
                                    </div>

                                    <div style="margin-bottom: 25px" class="control-group colortext">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                        <input type="text" class="form-control"
                                               name="place" value="${place}"
                                               pattern="[a-zA-Z0-9А-Яа-я_ -]{4,30}"
                                               placeholder="<fmt:message key="holder.place" bundle="${var}"/>*"
                                               required>
                                        <c:if test="${not empty incorrect_place}">
                                            <fmt:message key="incorrect.place" bundle="${var}"/>
                                        </c:if>
                                    </div>

                                    <div style="margin-bottom: 25px" class="control-group colortext">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                        <input type="time" class="form-control"
                                               name="time" value="${time}"
                                               placeholder="<fmt:message key="holder.time" bundle="${var}"/>*"
                                               required>
                                        <c:if test="${not empty incorrect_time}">
                                            <fmt:message key="incorrect.time" bundle="${var}"/>
                                        </c:if>
                                    </div>

                                    <div style="margin-bottom: 25px" class="control-group colortext">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                        <input type="date" class="form-control"
                                               name="date" value="${date}"
                                               placeholder="<fmt:message key="holder.date" bundle="${var}"/>*"
                                               required>
                                        <c:if test="${not empty incorrect_date}">
                                            <fmt:message key="incorrect.date" bundle="${var}"/>
                                        </c:if>
                                    </div>
                                    <div style="margin-bottom: 25px" class="control-group">
                                        <select class="selectpicker form-control" required name="horse№1">
                                            <option value="" disabled selected>
                                                <fmt:message key="horse" bundle="${var}"/>№1*</option>
                                            <c:forEach items="${horseNames}" var="name">
                                                <option>${name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div style="margin-bottom: 25px" class="control-group">

                                        <select class="selectpicker form-control" required name="horse№2">

                                            <option value="" disabled selected>
                                                <fmt:message key="horse" bundle="${var}"/>№2*</option>
                                            <c:forEach items="${horseNames}" var="name">
                                                <option>${name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div style="margin-bottom: 25px" class="control-group">
                                        <select class="selectpicker form-control" required name="horse№3">
                                            <option value="" disabled selected>
                                                <fmt:message key="horse" bundle="${var}"/>№3*</option>
                                            <c:forEach items="${horseNames}" var="name">
                                                <option>${name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div style="margin-bottom: 25px" class="control-group">
                                        <select class="selectpicker form-control" required name="horse№4">
                                            <option value="" disabled selected>
                                                <fmt:message key="horse" bundle="${var}"/>№4*</option>
                                            <c:forEach items="${horseNames}" var="name">
                                                <option>${name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <c:if test="${not empty not_different_horses}">
                                        <div class="colortext">
                                            <fmt:message key="info.samehorses" bundle="${var}"/>
                                        </div>
                                    </c:if>


                                    <div style="margin-top:10px" class="form-group">
                                        <div class="col-md-12 controls">
                                            <input type="submit" class="btn btn-success"
                                                   value="<fmt:message key="button.addrace" bundle="${var}"/>">
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                    <c:import url="../../common/footer.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>




</body>
</html>
