<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Brand</th>
                <th scope="col">Model</th>
                <th scope="col">Body Type</th>
                <th scope="col">Price</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cars}" var="car" varStatus="loop">
                <form action="/homework_27/home" method="post">
                    <tr>
                        <th scope="row">${loop.count}</th>
                        <td>${car.brand}</td>
                        <td>${car.model}</td>
                        <td>${car.body}</td>
                        <td>${car.price}</td>
                        <input type="hidden" name="carName" value="${car.uuid}"/>
                        <td><input type="submit" value="delete"></td>
                    </tr>
                </form>
            </c:forEach>

            </tbody>
        </table>
        <a href="addCar.jsp">Add new car</a>
    </div>
</div>
</body>
</html>
