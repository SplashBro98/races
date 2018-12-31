<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 13.12.2018
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title><fmt:message key="label.addRace" bundle="${var}"/></title>

    <link href="/css/main.css" rel="stylesheet" type="text/css">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          rel="stylesheet" id="bootstrap-css">

</head>
<body>
<c:import url="header.jsp"/>

<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <div class="container-fluid" style="background-color: dimgray">
                        <div class="container container-pad">
                            <div class="row">
                                <div class="col-sm-6">

                                    <div class="brdr bgc-fff pad-10 property-listing">
                                        <div class="media">
                                            <a class="pull-left" href="#" target="_parent">
                                                <img alt="image" class="img-responsive"
                                                     src="../../img/house.jpg"></a>


                                            <div class="media-body">
                                                <a href="#" target="_parent"></a>

                                                <h4 class="media-heading">
                                                    <a href="/main?command=select race&name=${race.name}"
                                                       target="_parent">${race.name}</a>
                                                </h4>


                                                <ul class="list-inline" style="color: black">
                                                    <li><h4>${race.time}</h4></li>
                                                    <li><h4>${race.date}</h4></li>

                                                </ul>

                                                <div style="color: black">
                                                    <h4>${race.place}</h4>
                                                </div>

                                            </div>
                                        </div>
                                    </div><!-- End Listing-->

                                </div>
                            </div>
                            <c:import url="horseTable.jsp"/>
                            <c:import url="betTable.jsp"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<c:import url="footer.jsp"/>
</body>
</html>
