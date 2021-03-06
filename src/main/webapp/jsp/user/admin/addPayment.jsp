<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.addPayment" bundle="${var}"/></title>

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
                             class="mainbox col-md-4  col-sm-8">
                            <div class="panel panel-info">
                                <div class="panel-heading" style="margin-bottom: 40px">
                                    <div class="panel-title text-center">
                                        <h3><fmt:message key="form.addpayment" bundle="${var}"/></h3></div>
                                </div>
                                <div class="panel-body">
                                    <form action="/main" method="post">
                                        <input type="hidden" name="command" value="add payment">

                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                            <input type="text" class="form-control"
                                                   name="paymentId"
                                                   pattern="^\d{2}-\d{3}-\d{3}$"
                                                   placeholder="**-***-***" required>
                                            <c:if test="${not empty incorrect_id}">
                                                <fmt:message key="incorrect.paymentid" bundle="${var}"/>
                                            </c:if>
                                        </div>

                                        <div style="margin-bottom: 25px" class="control-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-lock"></i></span>
                                            <input type="text" class="form-control"
                                                   name="sum"
                                                   pattern="^((?!0\.00)(0[.,]\d{2}|([1-9]\d{0,5})([.,]\d{2})?))$"
                                                   placeholder="<fmt:message key="holder.sum" bundle="${var}"/>*"
                                                   required>
                                            <fmt:message key="info.correctsum" bundle="${var}"/>
                                            <c:if test="${not empty incorrect_amount}">
                                                <fmt:message key="incorrect.amount" bundle="${var}"/>
                                            </c:if>
                                        </div>


                                        <div style="margin-top:10px" class="form-group">
                                            <div class="col-md-12 controls">
                                                <input type="submit" class="btn btn-success text-center"
                                                       value="<fmt:message key="button.addpayment" bundle="${var}"/>">
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
