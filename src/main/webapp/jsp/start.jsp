<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <link href="/css/header.css" rel="stylesheet" type="text/css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


</head>
<body>
<c:import url="withoutLoginHeader.jsp"/>


<section class="wrapper fixed-top">
    <div class="overlays"></div>
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <h1 class="mt-5"><fmt:message key="welcome" bundle="${var}"/> </h1>
                    <p>Here you can make bets</p>
                    <button class="btn btn-outline-primary  mt-5"><a href="/main?command=to log in">Sign In</a></button>
                    <button class="btn btn-outline-primary  mt-5"><a href="/main?command=to sign up">Sign Up</a>
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
