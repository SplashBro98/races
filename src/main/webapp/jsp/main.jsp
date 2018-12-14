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
    <title><fmt:message key="label.title" bundle="${var}"/></title>

    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-cs">


</head>
<body>

<c:import url="header.jsp"/>


<div class="container-fluid" style="background-color:#bbbbbb">
    <div class="container container-pad" style="margin-top: 20%" id="property-listings">

        <div class="row">
            <div class="text-center">
                <div class="col-md-12">
                    <h1>List of Races</h1>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-6">

                <c:forEach items="${races}" var="race">
                    <div class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing">
                        <div class="media">
                            <a class="pull-left" href="#" target="_parent">
                                <img alt="image" class="img-responsive"
                                     src="http://images.prd.mris.com/image/V2/1/Yu59d899Ocpyr_RnF0-8qNJX1oYibjwp9TiLy-bZvU9vRJ2iC1zSQgFwW-fTCs6tVkKrj99s7FFm5Ygwl88xIA.jpg"></a>

                            <div class="clearfix visible-sm"></div>

                            <div class="media-body fnt-smaller">
                                <a href="#" target="_parent"></a>

                                <h4 class="media-heading">
                                    <a href="/main?command=select race&name=${race.name}"
                                       target="_parent">${race.name}</a>
                                </h4>


                                <ul class="list-inline" style="color: black">
                                    <li><h5>${race.time}</h5></li>
                                    <li><h5>${race.date}</h5></li>

                                </ul>

                                <p style="color: black"><h5>${race.place}</h5></p>
                            </div>
                        </div>
                    </div>
                    <!-- End Listing-->

                </c:forEach>
                <%--<!-- Begin Listing: 609 W GRAVERS LN-->--%>


                <%--<!-- Begin Listing: 218 LYNNEBROOK LN-->--%>
                <%--<div class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing">--%>
                <%--<div class="media">--%>
                <%--<a class="pull-left" href="#" target="_parent">--%>
                <%--<img alt="image" class="img-responsive" src="http://images.prd.mris.com/image/V2/1/zMjCkcFeFDXDAP8xDhbD9ZmrVL7oGkBvSnh2bDBZ6UB5UHXa3_g8c6XYhRY_OxgGaMBMehiTWXDSLzBMaIzRhA.jpg"></a>--%>

                <%--<div class="clearfix visible-sm"></div>--%>

                <%--<div class="media-body fnt-smaller">--%>
                <%--<a href="#" target="_parent"></a>--%>

                <%--<h4 class="media-heading">--%>
                <%--<a href="#" target="_parent">$1,975,000 <small class="pull-right">218 Lynnebrook Ln</small></a></h4>--%>


                <%--<ul class="list-inline mrg-0 btm-mrg-10 clr-535353">--%>
                <%--<li>6,959 SqFt</li>--%>

                <%--<li style="list-style: none">|</li>--%>

                <%--<li>6 Beds</li>--%>

                <%--<li style="list-style: none">|</li>--%>

                <%--<li>5 Baths</li>--%>
                <%--</ul>--%>

                <%--<p class="hidden-xs">Impressively positioned--%>
                <%--overlooking 3.5 captivating acres, designated--%>
                <%--as "significant" by the chestnut hill--%>
                <%--historical s...</p><span class="fnt-smaller fnt-lighter fnt-arial">Courtesy of HS Fox & Roach-Blue Bell</span>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div><!-- End Listing-->--%>


            </div>

            <div class="col-sm-6">

                <!-- Begin Listing: 1220-32 N HOWARD ST-->
                <div class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing">
                    <div class="media">
                        <a class="pull-left" href="#" target="_parent">
                            <img alt="image" class="img-responsive"
                                 src="http://images.prd.mris.com/image/V2/1/vGoNjc2jHGb87GlnnDQlf6LxeOUgIOn0bL6Wvn1nEnig2Ntq6W7xN5cOQBZZeNxl9O42DOkHUw0LNnj1ZB2KHA.jpg"></a>

                        <div class="clearfix visible-sm"></div>

                        <div class="media-body fnt-smaller">
                            <a href="#" target="_parent"></a>

                            <h4 class="media-heading">
                                <a href="#" target="_parent">$1,500,000
                                    <small class="pull-right">1220-32 N Howard St</small>
                                </a></h4>


                            <ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
                                <li>4,900 SqFt</li>

                                <li style="list-style: none">|</li>

                                <li>1 Beds</li>

                                <li style="list-style: none">|</li>

                                <li>1 Baths</li>
                            </ul>

                            <p class="hidden-xs">A once in a lifetime
                                opportunity to own a unique live / work space
                                in one of philadelphia's most popular
                                neighborhoods. ...</p><span class="fnt-smaller fnt-lighter fnt-arial">Courtesy of ll Banker Preferred-Philadelphia</span>
                        </div>
                    </div>
                </div><!-- End Listing-->

                <!-- Begin Listing: 9006 CREFELD ST-->
                <div class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing">
                    <div class="media">
                        <a class="pull-left" href="#" target="_parent">
                            <img alt="image" class="img-responsive"
                                 src="http://images.prd.mris.com/image/V2/1/uLp58OH37CTPHxXcgJXYw8zT2u3xg_2XIbFndB6J0WTSAStGBaEV6YsdAseSZTKAdthm0OzG-Ca_EIkoXIEBxw.jpg"></a>

                        <div class="clearfix visible-sm"></div>

                        <div class="media-body fnt-smaller">
                            <a href="#" target="_parent"></a>

                            <h4 class="media-heading">
                                <a href="#" target="_parent">$1,295,000
                                    <small class="pull-right">9006 Crefeld St</small>
                                </a></h4>


                            <ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
                                <li>7,672 SqFt</li>

                                <li style="list-style: none">|</li>

                                <li>7 Beds</li>

                                <li style="list-style: none">|</li>

                                <li>5 Baths</li>
                            </ul>

                            <p class="hidden-xs">Located in chestnut hill,
                                recently named by the american planning
                                association as one of america's top 10 great
                                neighborh...</p><span
                                class="fnt-smaller fnt-lighter fnt-arial">Courtesy of RE/MAX Services</span>
                        </div>
                    </div>
                </div><!-- End Listing-->

            </div><!-- End Col -->
        </div><!-- End row -->
    </div><!-- End container -->
</div>


<%--<div class="container">--%>
<%--<h4>List of Races</h4>--%>
<%--<c:forEach items="${allRaces}" var="race">--%>
<%--<div class="row">--%>
<%--<a href="main?command=select race&name=${race.name}"/> ${race.name} <br/>--%>
<%--</div>--%>
<%--</c:forEach>--%>
<%--<form action="main" method="post" class="form-style-2">--%>
<%--<input type="hidden" name="command" value="to add race">--%>
<%--<input type="submit" value="Add Race">--%>
<%--</form>--%>
<%--</div>--%>

<%--<div class="container">--%>
<%--<div class="row">--%>
<%--<div class="col-md-2">Name</div>--%>
<%--<div class="col-md-2">Place</div>--%>
<%--<div class="col-md-2">Date</div>--%>
<%--<div class="col-md-2">Time</div>--%>
<%--</div>--%>
<%--<c:forEach items="${allRaces}" var="race">--%>
<%--<div class="row">--%>
<%--<div class="col-md-2">${race.name}</div>--%>
<%--<div class="col-md-2">${race.place}</div>--%>
<%--<div class="col-md-2">${race.date}</div>--%>
<%--<div class="col-md-2">${race.time}</div>--%>
<%--</div>--%>
<%--</c:forEach>--%>


<%--</div>--%>

<c:import url="footer.jsp"/>
<script>
    $(window).scroll(function(){
        if( $(this).scrollTop()>70){

            $('.navbar').css('background','#263238');

        }else{
            $('.navbar').css('background','#263238');
        }
    });
</script>


</body>
</html>
