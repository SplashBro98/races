<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title><fmt:message key="label.addBet" bundle="${var}"/></title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          rel="stylesheet" id="bootstrap-css">
</head>

<body>
<c:import url="../../common/header.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12 text-center">

                <div class="container">
                    <div style="margin-right: auto; margin-left: auto"
                         class="mainbox col-md-4  col-sm-4">
                        <div class="panel panel-info">
                            <div class="panel-heading" style="color: white">
                                <div class="panel-title"><h3><fmt:message key="form.addbet" bundle="${var}"/></h3>
                                </div>
                            </div>

                            <div style="padding-top:40px" class="panel-body">


                                <form class="form-horizontal" action="/main" method="post">
                                    <input type="hidden" name="command" value="add bet">

                                    <div style="margin-bottom: 25px" class="control-group">
                                        <select class="selectpicker form-control" name="raceName"
                                                required onchange="location = this.value;">


                                            <c:choose>
                                                <c:when test="${empty raceName}">
                                                    <option value="" disabled selected>
                                                        <fmt:message key="holder.nameofrace" bundle="${var}"/>*
                                                    </option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option selected>
                                                            ${raceName}
                                                    </option>
                                                </c:otherwise>
                                            </c:choose>

                                            <c:forEach items="${raceNames}" var="name">
                                                <option value="/main?command=select race horses&name=${name}">
                                                        ${name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div style="margin-bottom: 25px" class="control-group">

                                        <select class="selectpicker form-control" name="horseName" required>
                                            <option value="" disabled selected>
                                                <fmt:message key="holder.horsename" bundle="${var}"/>*</option>
                                            <c:forEach items="${horseNames}" var="name">
                                                <option>${name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div style="margin-bottom: 25px" class="control-group">

                                        <select class="selectpicker form-control" name="position" required>
                                            <option value="" disabled selected>
                                                <fmt:message key="holder.position" bundle="${var}"/>*</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                        </select>
                                    </div>

                                    <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                        <input type="text" class="form-control"
                                               name="coeff" pattern="^((?!0\.00)(0[.,]\d{2}|([1-9]\d{0,5})([.,]\d{2})?))$"
                                               placeholder="<fmt:message key="holder.coeff" bundle="${var}"/>*"
                                               oninvalid="this.setCustomValidity('<fmt:message key="info.correctsum"
                                                                                               bundle="${var}"/>')"
                                               oninput="this.setCustomValidity('')"
                                               required>
                                        <c:if test="${not empty incorrect_coeff}">
                                            <fmt:message key="incorrect.coeff" bundle="${var}"/>
                                        </c:if>
                                    </div>


                                    <div style="margin-top:10px" class="form-group">
                                        <div class="col-md-12 controls">
                                            <input type="submit" class="btn btn-success"
                                                   value="<fmt:message key="button.addbet" bundle="${var}"/>">
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
