<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="salah" uri="liverpool" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title><fmt:message key="label.entersum" bundle="${var}"/></title>
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
                                        <h3><fmt:message key="form.entersum" bundle="${var}"/></h3></div>
                                </div>
                                <div class="panel-body">
                                    <form action="/main" method="post">
                                        <input type="hidden" name="command" value="enter sum">
                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                            <input type="text" class="form-control"
                                                   name="sum"
                                                   pattern="^((?!0\.00)(0[.,]\d{2}|([1-9]\d{0,5})([.,]\d{2})?))$"
                                                   placeholder="Sum*" required>
                                            <c:if test="${not empty is_incorrect_sum}">
                                                <div class="text-center"><fmt:message key="info.sum" bundle="${var}"/></div>
                                            </c:if>
                                        </div>


                                        <div style="margin-top:10px" class="form-group">
                                            <!-- Button -->
                                            <div class="col-md-12 controls">
                                                <input type="submit" class="btn btn-success text-center"
                                                       value="<fmt:message key="button.makebet" bundle="${var}"/>">
                                            </div>
                                        </div>
                                    </form>
                                    <form class="form-horizontal" action="/main" method="post">
                                        <input type="hidden" name="command" value="to top up balance">
                                        <div style="margin-top:10px" class="form-group">
                                            <!-- Button -->
                                            <div class="col-md-12 controls">
                                                <input type="submit" class="btn btn-primary text-center"
                                                       value="<fmt:message key="header.topup" bundle="${var}"/>">
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


<%--<section class="wrapper fixed-top">--%>
<%--<div class="overlays"></div><!--Mascara de imagen-->--%>
<%--<div class="container h-100">--%>
<%--<div style="margin-top:120px; margin-left: 30%" class="mainbox col-md-4 col-sm-8">--%>
<%--<div class="panel panel-info">--%>
<%--<div class="panel-heading">--%>
<%--<div class="panel-title text-center" style="color: white"><h4>Please, enter the Sum of Bet</h4>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div style="padding-top:40px" class="panel-body">--%>


<%--<form class="form-horizontal" action="/main" method="post">--%>
<%--<input type="hidden" name="command" value="enter sum">--%>


<%--<div style="margin-bottom: 25px" class="control-group">--%>
<%--<span class="input-group-addon"><i--%>
<%--class="glyphicon glyphicon-lock"></i></span>--%>
<%--<input type="text" class="form-control"--%>
<%--name="sum"--%>
<%--pattern="^[0-9]*[.,]?[0-9]+$"--%>
<%--placeholder="Sum*" required>--%>
<%--<div class="text-center"> ${incorrect_sum}</div>--%>
<%--</div>--%>


<%--<div style="margin-top:10px" class="form-group">--%>
<%--<!-- Button -->--%>
<%--<div class="col-md-12 controls">--%>
<%--<input type="submit" class="btn btn-success text-center" value="Make Bet">--%>
<%--</div>--%>
<%--</div>--%>

<%--</form>--%>
<%--<form class="form-horizontal" action="/main" method="post">--%>
<%--<input type="hidden" name="command" value="to top up balance">--%>
<%--<div style="margin-top:10px" class="form-group">--%>
<%--<!-- Button -->--%>
<%--<div class="col-md-12 controls">--%>
<%--<input type="submit" class="btn btn-success text-center" value="Top Up Balance">--%>
<%--</div>--%>
<%--</div>--%>
<%--</form>--%>

<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</section>--%>

<c:import url="../../common/footer.jsp"/>

</body>
</html>
