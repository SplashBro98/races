<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">

    <link href="/css/header.css" rel="stylesheet" type="text/css">

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
