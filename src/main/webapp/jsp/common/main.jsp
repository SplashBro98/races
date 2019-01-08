<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="salah" uri="liverpool" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.main" bundle="${var}"/></title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          rel="stylesheet" id="bootstrap-css">

</head>
<body>

<c:import url="header.jsp"/>


<div class="parallax" style="height: max-content">
    <div class="overlays"></div>
    <div class="container h-100" style="margin-top: 7%">
        <div class="col-lg-12">
            <div class="text-center">

                <div class="container">
                    <div class="container-fluid" style="background-color: dimgray">
                        <div class="container container-pad" id="property-listings">
                            <div class="row">
                                <div class="col-md-12 my-header" style="color: white;">
                                    <h2><fmt:message key="list.races" bundle="${var}"/></h2>
                                </div>
                            </div>

                            <div class="row">

                                <c:forEach items="${races}" var="race">
                                    <div class="col-sm-6 col-md-6 col-xs-6">
                                        <div class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing">
                                            <div class="media">
                                                <a class="pull-left" href="#" target="_parent">
                                                    <img alt="image" class="img-responsive"
                                                         src="/img/races.jpg"></a>


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
                            <div class="row" style="margin-right: auto; margin-left: auto">
                                <nav style="font-size: large; margin-right: auto; margin-left: auto">
                                    <ul class="pagination">
                                        <c:if test="${currentPage != 1}">
                                            <li class="page-item">
                                                <a class="page-link"
                                                   href="/main?command=pagination&currentPage=${currentPage - 1}">
                                                    <fmt:message key="button.previous" bundle="${var}"/></a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="1" end="${numberOfPages}" var="i">
                                            <c:choose>
                                                <c:when test="${currentPage eq i}">
                                                    <li class="page-item active">
                                                        <a class="page-link"
                                                           href="/main?command=pagination&currentPage=${i}">${i}
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
                                                <a class="page-link"
                                                   href="/main?command=pagination&currentPage=${currentPage + 1}">
                                                    <fmt:message key="button.next" bundle="${var}"/></a>
                                            </li>
                                        </c:if>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<c:import url="footer.jsp"/>


</body>
</html>