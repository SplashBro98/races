<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title><fmt:message key="label.holdrace" bundle="${var}"/></title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          rel="stylesheet" id="bootstrap-css">

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
                        <div style="margin-right: auto; margin-left: auto"
                             class="mainbox col-md-4  col-sm-8">
                            <div class="panel panel-info">
                                <div class="panel-heading" style="margin-bottom: 40px">
                                    <div class="panel-title text-center">
                                        <h3><fmt:message key="selectrace" bundle="${var}"/></h3></div>
                                </div>
                                <div class="panel-body">
                                    <form action="/main" method="post">
                                        <input type="hidden" name="command" value="hold race">

                                        <div style="margin-bottom: 25px" class="control-group">
                                            <select class="selectpicker form-control" name="raceName"
                                                    required>
                                                <option value="" disabled selected>
                                                    <fmt:message key="holder.nameofrace" bundle="${var}"/>*
                                                </option>

                                                <c:forEach items="${raceNames}" var="name">
                                                    <option> ${name} </option>
                                                </c:forEach>
                                            </select>
                                        </div>


                                        <div style="margin-top:10px" class="form-group">
                                            <div class="col-md-12 controls">
                                                <input type="submit" class="btn btn-success text-center"
                                                       value="<fmt:message key="button.holdrace" bundle="${var}"/>">
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
