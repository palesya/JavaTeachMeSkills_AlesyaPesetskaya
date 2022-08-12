<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>

<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
            integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
            crossorigin="anonymous"></script>
</head>

<body>
<h1>List of all cars from database</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Id</th>
        <th scope="col">Brand</th>
        <th scope="col">Number</th>
        <th scope="col">Produced</th>
        <th scope="col">Availability</th>
        <th scope="col">Created</th>
        <th scope="col">Updated</th>
        <th scope="col">Version</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.brand}</td>
            <td>${car.number}</td>
            <td>${car.dateProduced}</td>
            <td>${car.available}</td>
            <td>${car.created}</td>
            <td>${car.updated}</td>
            <td>${car.version}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3>Change availability of car with id:</h3>
<form action="car" method="post">
    <select name="selected_id">
        <option selected="selected">0</option>
        <c:forEach items="${ids}" var="id">
            <option>${id}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Submit">
</form>

</body>
</html>
