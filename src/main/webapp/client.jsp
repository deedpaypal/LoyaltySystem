<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">${test}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/clients">Clients</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/events">Events</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/rules">Rules</a>
            </li>
        </ul>
    </div>
</nav>
<br>
<div class="form-group col-md-6">
    <p style="font-size: 50px" class="text-dark">Single loyalty programs</p>
</div>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ClientID</th>
        <th scope="col">Type</th>
        <th scope="col">Sum</th>
        <th scope="col">Event</th>
        <th scope="col">Bonuses</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="counterAndEvent" items="${counterAndEvents}">
        <tr>
            <form method="post" action="?single">
                <th scope="row">
                    <input name="clientID" value="${counterAndEvent.firstElement.clientID}"
                           style="display: none">
                        ${counterAndEvent.firstElement.clientID}</th>
                <td><input name="counterName" value="${counterAndEvent.firstElement.name}"
                           style="display: none">${counterAndEvent.firstElement.name}</td>

                <td><input name="counterAmountOfSum" value="${counterAndEvent.firstElement.amountOfSum}"
                           style="display: none">${counterAndEvent.firstElement.amountOfSum}</td>

                <td>
                    <select class="form-control" name="event">
                        <c:forEach var="event" items="${counterAndEvent.secondElement}">
                            <option value="${event.counterName} - ${event.limit}">${event.counterName}
                                - ${event.limit}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <button type="submit" class="btn btn-primary">Get bonuses</button>
                </td>
            </form>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<div class="form-group col-md-6">
    <p style="font-size: 50px" class="text-dark">Complicated loyalty programs</p>
</div>


<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ClientID</th>
        <th scope="col">Events</th>
        <th scope="col">Coefficient</th>
        <th scope="col">Bonuses</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="rule" items="${rules}">
        <tr>
            <form method="post" action="?complicated">
                <th scope="row">
                    <input name="clientID" value="${clientID}"
                           style="display: none">
                        ${clientID}</th>
                <td><input name="ruleID" value="${rule.id}"
                           style="display: none">
                    <c:forEach var="event" items="${rule.coeffsAndEvents.secondElement}">
                        ${event.counterName} - ${event.limit}
                        <br>
                    </c:forEach>
                </td>

                <td><input name="coefficient" value="${rule.coeffsAndEvents.firstElement}"
                           style="display: none">${rule.coeffsAndEvents.firstElement}
                </td>
                <td>
                    <button type="submit" class="btn btn-primary">Get bonuses</button>
                </td>
            </form>
        </tr>
    </c:forEach>
    </tbody>
</table>


<div class="d-flex justify-content-center">
    <h1 style="font-size: 50px" class="text-info">${bonuses}</h1>
</div>

</body>

</html>