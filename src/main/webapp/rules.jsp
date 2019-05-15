<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%--<html>--%>
<%--<head>--%>
<%--<meta charset="UTF-8"/>--%>
<%--<title>Welcome</title>--%>
<%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"--%>
<%--integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
<%--integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"--%>
<%--crossorigin="anonymous"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"--%>
<%--integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"--%>
<%--crossorigin="anonymous"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"--%>
<%--integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"--%>
<%--crossorigin="anonymous"></script>--%>

<%--</head>--%>
<%--<body>--%>
<%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark">--%>
<%--<a class="navbar-brand" href="#">${test}</a>--%>
<%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"--%>
<%--aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--<span class="navbar-toggler-icon"></span>--%>
<%--</button>--%>
<%--<div class="collapse navbar-collapse" id="navbarNav">--%>
<%--<ul class="navbar-nav">--%>
<%--<li class="nav-item active">--%>
<%--<a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>--%>
<%--</li>--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link" href="/clients">Clients</a>--%>
<%--</li>--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link" href="/secondElement">Events</a>--%>
<%--</li>--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link" href="/rules">Rules</a>--%>
<%--</li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</nav>--%>
<%--<br>--%>
<%--<form method="post" action="">--%>
<%--<div class="col-lg-4 col-sm-12">--%>
<%--<select class="form-control" name="type" placeholder="type">--%>
<%--<c:forEach var="item" items="${types}">--%>
<%--<option value="${item}">${item}</option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</div>--%>
<%--<div class="col-lg-4 col-sm-12">--%>
<%--<p>--%>
<%--<input class="form-control" name="limit" type="text" placeholder="limit">--%>
<%--</p>--%>
<%--</div>--%>

<%--<div class="col-lg-4 col-sm-12">--%>
<%--<p>--%>
<%--<input class="form-control" name="condition" type="text" placeholder="condition">--%>
<%--</p>--%>
<%--</div>--%>

<%--<div class="col-lg-4 col-sm-12">--%>
<%--<p>--%>
<%--<button class="btn btn-primary" type="submit" value="Create an Event">Create an Event</button>--%>
<%--</p>--%>
<%--</div>--%>
<%--</form>--%>


<%--<table class="table table-bordered">--%>
<%--<thead class="thead-primary">--%>
<%--<tr>--%>
<%--<th scope="col">Type</th>--%>
<%--<th scope="col">Limit</th>--%>
<%--<th scope="col">Condition</th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<tbody>--%>
<%--<c:forEach var="event" items="${secondElement}">--%>
<%--<tr>--%>
<%--<td>${event.operationType}</td>--%>
<%--<td>${event.limit}</td>--%>
<%--<td>${event.condition}</td>--%>

<%--</tr>--%>
<%--</c:forEach>--%>
<%--</tbody>--%>
<%--</table>--%>
<%--</body>--%>

<%--</html>--%>

<html>
<head>
    <script type='text/javascript'>

        function addFields() {
            var allEvents = document.querySelectorAll('div[name="event"]'),
                lastEvent = allEvents[allEvents.length - 1];
            var cln = lastEvent.cloneNode(true);
            lastEvent.parentNode.insertBefore(cln, lastEvent.nextSibling);

            var eventNames = document.getElementsByClassName("eventName"),
                lastEventName = eventNames[eventNames.length - 1];
            lastEventName.innerHTML = "Event " + (eventNames.length);

            var limits = document.getElementsByName("limit"),
                lastLimit = limits[limits.length - 1];
            lastLimit.innerHTML = "";

            var conditions = document.getElementsByName("condition"),
                lastCondition = conditions[conditions.length - 1];
            lastCondition.innerHTML = "";

            // var allEvents2 = document.querySelectorAll('div[name="event"]');
            // var lastEvent2 = allEvents2[allEvents2.length - 1];
            // lastEvent2.getElementsByClassName("eventName").innerHTML = "Event " + allEvents2.length;
            //allEvents2[allEvents2.length - 1].getElementsByClassName("eventName").innerHTML = "Event " + allEvents2.length;
        }

    </script>
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
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
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
<form method="post">
    <div name="event">
        <br>
        <div class="col-lg-4 col-sm-12">
            <h4 class="eventName">Event 1</h4>
        </div>
        <br>
        <div class="col-lg-4 col-sm-12">
            <p>
                <select class="form-control" name="type" placeholder="type">
                    <c:forEach var="item" items="${types}">
                        <option value="${item}">${item}</option>
                    </c:forEach>
                </select>
            </p>
        </div>

        <div class="col-lg-4 col-sm-12">
            <p>
                <input class="form-control" name="limit" type="text" placeholder="limit">
            </p>
        </div>

        <div class="col-lg-4 col-sm-12">
            <p>
                <input class="form-control" name="condition" type="text" placeholder="condition">
            </p>
        </div>
    </div>

    <div class="col-lg-4 col-sm-12">
        <p><a class="btn btn-success" role="button" onclick="addFields()">+ Event</a></p>
    </div>

    <br>
    <br>
    <div class="col-lg-4">
        <div class="form-group w-25">
            <p>
                <input class="form-control form-control-sm" name="coefficient" type="text"
                       placeholder="coefficient">
            </p>
        </div>
    </div>
    <br>
    <div class="col-lg-4 col-sm-12">
        <p>
            <button class="btn btn-primary" type="submit" value="Create an Event">Create a Rule</button>
        </p>
    </div>
</form>

<div class="d-flex justify-content-center">
    <h1 style="font-size: 50px" class="text-info">${rule.coeffsAndEvents}</h1>
</div>
</body>
</html>