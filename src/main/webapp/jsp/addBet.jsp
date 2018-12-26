<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 14.12.2018
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title>Add Bet</title>
</head>
<body>
<c:import url="header.jsp"/>
<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div style="margin-top:120px; margin-left: 30%" class="mainbox col-md-4 col-sm-8">
            <div class="panel panel-info">
                <div class="panel-heading" style="color: white">
                    <div class="panel-title"><h3>Add Bet Form</h3></div>
                </div>


                <div style="padding-top:40px" class="panel-body">

                    <div style="display:none" id="login-alert"
                         class="alert alert-danger col-sm-12"></div>

                    <form class="form-horizontal" action="/main" method="post">
                        <input type="hidden" name="command" value="add bet">

                        <div style="margin-bottom: 25px" class="control-group">
                            <select class="selectpicker form-control" required>
                                <option value="" disabled selected>Name of the Race*</option>
                                <c:forEach items="${raceNames}" var="name">
                                    <option href="/main?command=select race horses&name=${name}">
                                            ${name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div style="margin-bottom: 25px" class="control-group">

                            <select class="selectpicker form-control" required>
                                <option value="" disabled selected>Horse Name*</option>
                                <c:forEach items="${horseNames}" var="name">
                                    <option>${name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div style="margin-bottom: 25px" class="control-group">

                            <select class="selectpicker form-control" required>
                                <option value="" disabled selected>Position*</option>
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
                                   name="coeff"
                                   placeholder="Coefficient*" required>
                        </div>


                        <div style="margin-top:10px" class="form-group">
                            <!-- Button -->
                            <div class="col-md-12 controls">
                                <input type="submit" class="btn btn-success" value="Add Bet">
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</section>


<c:import url="footer.jsp"/>
</body>
</html>
