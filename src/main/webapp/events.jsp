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
<br>
<form method="post" action="">
    <div class="form-group col-md-6">
        <select class="form-control" name="type" placeholder="type">
            <c:forEach var="item" items="${types}">
                <option value="${item}">${item}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group col-md-6">
        <p>
            <input class="form-control" name="limit" type="text" placeholder="limit">
        </p>
    </div>

    <div class="form-group col-md-6">
        <p>
            <input class="form-control" name="condition" type="text" placeholder="condition">
        </p>
    </div>

    <div class="form-group col-md-6">
        <p>
            <button class="btn btn-primary" type="submit" value="Create an Event">Create an Event</button>
        </p>
    </div>
</form>


<table class="table table-bordered">
    <thead class="thead-primary">
    <tr>
        <th scope="col">Type</th>
        <th scope="col">Limit</th>
        <th scope="col">Condition</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="event" items="${events}">
        <tr>
            <td>${event.operationType}</td>
            <td>${event.limit}</td>
            <td>${event.condition}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>

</html>