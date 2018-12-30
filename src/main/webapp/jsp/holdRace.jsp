<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="salah" uri="liverpool" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="header.jsp"/>
<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div style="margin-top:120px; margin-left: 30%" class="mainbox col-md-4 col-sm-8">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title text-center" style="color: white"><h4>Please, select race </h4></div>
                </div>

                <div style="padding-top:40px" class="panel-body">


                    <form class="form-horizontal" action="/main" method="post">
                        <input type="hidden" name="command" value="hold race">

                        <div style="margin-bottom: 25px" class="control-group">
                            <select class="selectpicker form-control" name="raceName"
                                    required>
                                <option value="" disabled selected>
                                    Name of the Race*
                                </option>

                                <c:forEach items="${raceNames}" var="name">
                                    <option> ${name} </option>
                                </c:forEach>
                            </select>
                        </div>


                        <div style="margin-top:10px" class="form-group">
                            <!-- Button -->
                            <div class="col-md-12 controls">
                                <input type="submit" class="btn btn-success text-center" value="Hold Race">
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
