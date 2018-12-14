<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profile</title>
    <link href="/css/profile.css" rel="stylesheet" type="text/css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>

<c:import url="header.jsp"/>
<div class="container">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">${user.name} ${user.surname}</h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="text-center">
                    <div class=" col-md-9">
                        <table class="table table-user-information">
                            <tbody class="colortext">
                            <tr>
                                <td>Login:</td>
                                <td>${user.login}</td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>${user.email}</td>
                            </tr>

                            <tr>
                            </tbody>
                        </table>


                        <a href="/main?commad=edit profile" class="btn btn-primary">Edit Profile</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>


</body>
</html>
