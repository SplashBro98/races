<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 01.11.2018
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="salah" uri="liverpool" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title><fmt:message key="label.main" bundle="${var}"/></title>

    <link href="/css/main.css" rel="stylesheet" type="text/css">

    <%--<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--id="bootstrap-css">--%>
    <%----%>

    <%--<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"--%>
          <%--id="bootstrap-cs">--%>
    <link href="/vendors/bootstrap/css/bootstrap_main.min.css">
</head>
<body>


<c:import url="header.jsp"/>

<div class="overlays"></div><!--Mascara de imagen-->
<div class="container h-100" style="margin-top: 50px">
    <div class="container-fluid" id="first" style="background-color: gainsboro">
        <div class="container container-pad" id="property-listings">

            <div class="row">
                <div class="col-md-12 my-header" style="color: white;">
                    <h1>List of Races</h1>
                </div>
            </div>

            <div class="row">

                <c:forEach items="${races}" var="race">
                    <div class="col-sm-6">
                        <div class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing">
                            <div class="media">
                                <a class="pull-left" href="#" target="_parent">
                                    <img alt="image" class="img-responsive"
                                         src="/img/house.jpg"></a>

                                <div class="clearfix visible-sm"></div>

                                <div class="media-body fnt-smaller">
                                    <a href="#" target="_parent"></a>

                                    <h5 class="media-heading">
                                        <a href="/main?command=select race&name=${race.name}"
                                           target="_parent">${race.name}</a>
                                    </h5>


                                    <ul class="list-inline" style="color: black">
                                        <li>${race.time}</li>
                                        <li>${race.date}</li>

                                    </ul>

                                    <p style="color: black">${race.place}</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- End Listing-->

                </c:forEach>
            </div><!-- End row -->
        </div>
        <nav style="font-size: large; margin-right: -50%">
            <ul class="pagination">
                <c:if test="${currentPage != 1}">
                    <li class="page-item">
                        <a class="page-link" href="/main?command=pagination&currentPage=${currentPage - 1}">Previous</a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${numberOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <li class="page-item active">
                                <a class="page-link" href="/main?command=pagination&currentPage=${i}">${i}
                                    <span class="sr-only">(current)</span></a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link"
                                   href="/main?command=pagination&currentPage=${i}">${i}
                                    <span class="sr-only">(current)</span></a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage lt numberOfPages}">
                    <li class="page-item">
                        <a class="page-link" href="/main?command=pagination&currentPage=${currentPage + 1}">Next</a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>

<c:import url="footer.jsp"/>


</body>
</html>