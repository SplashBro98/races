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
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap">
    <%--<link href="/vendors/bootstrap/css/bootstrap_table.min.css">--%>
    <%--<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
    <%--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">List of your bets</h3>
                </div>
                <table class="table table-hover" id="dev-table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Race Name</th>
                        <th>Horse Name</th>
                        <th>Position</th>
                        <th>Coefficient</th>
                        <th>Sum of the Bet</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userBets}" var="userBet" varStatus="counter">

                        <input type="hidden" name="raceName" value="${race.raceId}">
                        <tr>
                            <td>${counter.count}</td>
                            <td> <a href="/main?command=select race&name=${userBet.getRace().getName()}"
                                    target="_parent">${userBet.getRace().getName()}</a></td>
                            <td>${userBet.getHorse().getName()}</td>
                            <td>${userBet.getPosition()}</td>
                            <td>${userBet.getCoeff()}</td>
                            <td>${userBet.getSum()}</td>
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






<%--<div class="container">--%>
    <%--<div class="row">--%>

        <%--<div class="col-md-12" style="color: white">--%>
            <%--<h2>List of your current bets</h2>--%>
            <%--<div class="table-responsive">--%>


                <%--<table id="mytable" class="table table-bordred table-striped" style="color: white">--%>

                    <%--<thead>--%>

                    <%--&lt;%&ndash;<th><input type="checkbox" id="checkall" /></th>&ndash;%&gt;--%>
                    <%--<th>Race name</th>--%>
                    <%--<th>Place</th>--%>
                    <%--<th>Time</th>--%>
                    <%--<th>Date</th>--%>
                    <%--<th>Describe</th>--%>
                    <%--<th>Coefficient</th>--%>
                    <%--<th>Amount</th>--%>
                    <%--&lt;%&ndash;<th>Edit</th>&ndash;%&gt;--%>

                    <%--&lt;%&ndash;<th>Delete</th>&ndash;%&gt;--%>
                    <%--</thead>--%>
                    <%--<tbody>--%>


                    <%--<c:forEach items="${userBets}" var="bet">--%>


                        <%--<tr>--%>
                                <%--&lt;%&ndash;<td><input type="checkbox" class="checkthis" /></td>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<td>Mohsin</td>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<td>Irshad</td>&ndash;%&gt;--%>
                            <%--<td>${bet.race.name}</td>--%>
                            <%--<td>${bet.race.place}</td>--%>
                            <%--<td>${bet.race.time}</td>--%>
                            <%--<td>${bet.race.date}</td>--%>
                            <%--<td>${bet.describe}</td>--%>
                            <%--<td>${bet.coeff}</td>--%>
                                <%--&lt;%&ndash;<td>isometric.mohsin@gmail.com</td>&ndash;%&gt;--%>
                            <%--<td>${bet.sum}</td>--%>
                                <%--&lt;%&ndash;<td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>&ndash;%&gt;--%>
                        <%--</tr>--%>


                    <%--</c:forEach>--%>

                    <%--</tbody>--%>

                <%--</table>--%>
                <%--<div style="color: white">--%>
                    <%--<h2>${nothing}</h2>--%>
                <%--</div>--%>

            <%--</div>--%>

        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


</body>
</html>
