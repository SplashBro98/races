<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 13.12.2018
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text" var="var"/>
<html>
<head>
    <meta charset="utf-8">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
            integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
            integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">List of possible bets</h3>
                </div>
                <table class="table table-hover" id="dev-table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Horse Name</th>
                        <th>Position</th>
                        <th>Coefficient</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${bets}" var="bet" varStatus="counter">


                        <tr>
                            <td>${counter.count}</td>
                            <td>${horseNames.get(counter.count - 1)}</td>
                            <td>${bet.position}</td>
                            <td>${bet.coeff}</td>
                            <td>

                                <button class="btn btn-success"data-toggle="modal">
                                    <a href="/main?command=to enter sum&betId=${bet.betId}" style="color: white">Make Bet</a>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<%--<div class="container">--%>
    <%--<div class="row">--%>

        <%--<div class="col-md-12" style="color: white">--%>
            <%--<h2>List of possible bets</h2>--%>
            <%--<div class="table-responsive">--%>


                <%--<table id="mytable" class="table table-bordred table-striped" style="color: white">--%>

                    <%--<thead>--%>
                    <%--<th>#</th>--%>
                    <%--<th>Horse Name</th>--%>
                    <%--<th>Position</th>--%>
                    <%--<th>Coefficient</th>--%>
                    <%--</thead>--%>
                    <%--<tbody>--%>

                    <%--<c:forEach items="${bets}" var="bet" varStatus="counter">--%>


                            <%--<input type="hidden" name="raceName" value="${race.raceId}">--%>
                            <%--<tr>--%>
                                <%--<td>${counter.count}</td>--%>
                                <%--<td>${horseNames.get(counter.count - 1)}</td>--%>
                                <%--<td>${bet.position}</td>--%>
                                <%--<td>${bet.coeff}</td>--%>
                                <%--<td>--%>
                                        <%--&lt;%&ndash;<input type="submit" class="btn btn-success"&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;data-toggle="modal" data-target="#exampleModal" value="Make Bet">&ndash;%&gt;--%>
                                    <%--<button class="btn btn-success" data-toggle="modal">--%>
                                        <%--Make Bet--%>
                                    <%--</button>--%>
                                <%--</td>--%>

                            <%--</tr>--%>
                    <%--</c:forEach>--%>
                    <%--</tbody>--%>
                <%--</table>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
</body>
</html>
