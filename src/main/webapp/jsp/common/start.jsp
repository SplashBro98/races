<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <title><fmt:message key="label.start" bundle="${var}"/> </title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <link href="/css/header.css" rel="stylesheet" type="text/css">

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
                    <p><fmt:message key="start.describe" bundle="${var}"/> </p>
                    <button class="btn btn-outline-primary  mt-5">
                        <a href="/main?command=to log in"><fmt:message key="label.signin" bundle="${var}"/> </a>
                    </button>
                    <button class="btn btn-outline-primary  mt-5">
                        <a href="/main?command=to sign up"><fmt:message key="label.signup" bundle="${var}"/></a>
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
