<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 21.12.2018
  Time: 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-md-12" style="color: white">
            <h2>List of your current bets</h2>
            <div class="table-responsive">


                <table id="mytable" class="table table-bordred table-striped" style="color: white">

                    <thead>

                    <%--<th><input type="checkbox" id="checkall" /></th>--%>
                    <th>Race name</th>
                    <th>Place</th>
                    <th>Time</th>
                    <th>Date</th>
                    <th>Describe</th>
                    <th>Coefficient</th>
                    <th>Amount</th>
                    <%--<th>Edit</th>--%>

                    <%--<th>Delete</th>--%>
                    </thead>
                    <tbody>


                    <c:forEach items="${userBets}" var="bet">


                        <tr>
                                <%--<td><input type="checkbox" class="checkthis" /></td>--%>
                                <%--<td>Mohsin</td>--%>
                                <%--<td>Irshad</td>--%>
                            <td>${bet.race.name}</td>
                            <td>${bet.race.place}</td>
                            <td>${bet.race.time}</td>
                            <td>${bet.race.date}</td>
                            <td>${bet.describe}</td>
                            <td>${bet.coeff}</td>
                                <%--<td>isometric.mohsin@gmail.com</td>--%>
                            <td>${bet.sum}</td>
                                <%--<td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>--%>
                                <%--<td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>--%>
                        </tr>


                    </c:forEach>

                    </tbody>

                </table>
                <div style="color: white">
                    <h2>${nothing}</h2>
                </div>

            </div>

        </div>
    </div>
</div>


</body>
</html>
