<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 09.12.2018
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">

    <link href="/css/header.css" rel="stylesheet" type="text/css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<script>
    $(window).scroll(function () {
        if ($(this).scrollTop() > 70) {

            $('.navbar').css('background', '#263238');

        } else {
            $('.navbar').css('background', 'transparent');
        }
    });
</script>
</body>
</html>
