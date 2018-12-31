<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="salah" uri="liverpool" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title><fmt:message key="label.addRace" bundle="${var}"/></title>
</head>
<body>
<c:import url="../../common/header.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <div class="container">
                        <div style="margin-right: auto; margin-left: auto; margin-top: 140px"
                             class="mainbox col-md-4  col-sm-8">
                            <div class="panel panel-info">
                                <div class="panel-heading" style="margin-bottom: 40px">
                                    <div class="panel-title text-center">
                                        <h3><fmt:message key="form.addrace" bundle="${var}"/></h3></div>
                                </div>
                                <div class="panel-body">
                                    <form action="/main" method="post">
                                        <input type="hidden" name="command" value="add race">

                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-user"></i></span>
                                            <input type="text" class="form-control" name="name" value="${name}"
                                                   pattern="[a-zA-Z0-9А-Яа-я_ -]{4,30}"
                                                   placeholder="Name*" required>
                                            <div class="text-center"> ${incorrect_name}</div>
                                        </div>

                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                            <input type="text" class="form-control"
                                                   name="place" value="${place}"
                                                   pattern="[a-zA-Z0-9А-Яа-я_ -]{4,30}"
                                                   placeholder="Place*" required>
                                            <div class="text-center"> ${incorrect_place}</div>
                                        </div>
                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                            <input type="time" class="form-control"
                                                   name="time" value="${time}"
                                                   placeholder="Time*" required>
                                            <div class="text-center"> ${incorrect_time}</div>
                                        </div>
                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                            <input type="date" class="form-control"
                                                   name="date" value="${date}"
                                                   placeholder="Date*" required>
                                            <div class="text-center"> ${incorrect_date}</div>
                                        </div>
                                        <div style="margin-bottom: 25px" class="control-group">
                                            <select class="selectpicker form-control" required name="horse№1">
                                                <option value="" disabled selected>Horse№1*</option>
                                                <c:forEach items="${horseNames}" var="name">
                                                    <option>${name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div style="margin-bottom: 25px" class="control-group">
                                            <select class="selectpicker form-control" required name="horse№2">
                                                <option value="" disabled selected>Horse№2*</option>
                                                <c:forEach items="${horseNames}" var="name">
                                                    <option>${name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div style="margin-bottom: 25px" class="control-group">
                                            <select class="selectpicker form-control" required name="horse№3">
                                                <option value="" disabled selected>Horse№3*</option>
                                                <c:forEach items="${horseNames}" var="name">
                                                    <option>${name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div style="margin-bottom: 25px" class="control-group">
                                            <select class="selectpicker form-control" required name="horse№4">
                                                <option value="" disabled selected>Horse№4*</option>
                                                <c:forEach items="${horseNames}" var="name">
                                                    <option>${name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>


                                        <div style="margin-top:10px" class="form-group">
                                            <!-- Button -->
                                            <div class="col-md-12 controls">
                                                <input type="submit" class="btn btn-success"
                                                       value="<fmt:message key="button.addrace" bundle="${var}"/>">
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

<c:import url="../../common/footer.jsp"/>

</body>
</html>
