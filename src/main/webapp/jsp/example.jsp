<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 11.12.2018
  Time: 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="/css/try.css" rel="stylesheet" type="text/css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top" id="up">
    <a class="navbar-brand" href="#">LOGO</a>
    <button class="navbar-toggler" type="button"
            data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">Disabled</a>
            </li>
        </ul>

    </div>
</nav>

<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <h1 class="mt-5">Conviértete en un Desarrollador Web Profesional.</h1>
                    <p>APRENDE DESARROLLO WEB MODERNO CON LARAVEL, VUEJS, Y OTRAS TECNOLOGÍAS.
                        Videotutoriales cortos y precisos para que aproveches tu tiempo al máximo .
                    </p>
                    <button class="btn btn-success btn-outline  mt-5">Iniciar sesion</button>
                    <button class="btn btn-outline-primary  mt-5">REGISTRATE</button>

                </div>


            </div>
        </div>
    </div>
</section>

<section class="cuerpo mt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eius magni, esse quod dolores veritatis facilis cum ratione aliquam fugit iure laudantium eaque atque eum cupiditate, labore necessitatibus repudiandae a molestiae.


            </div>

        </div>

    </div>

</section>
<script>
    $(window).scroll(function(){
        if( $(this).scrollTop()>50){

            $('.navbar').css('background','#263238');

        }else{
            $('.navbar').css('background','transparent');
        }
    });
</script>
</body>
</html>
