<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/homework_27/addCar" method="post">
        <div class="form-row">
            <div class="form-group col-md-2 mb-3">
                <label for="inputBrand">Brand</label>
                <input type="text" class="form-control" id="inputBrand" placeholder="Brand" name="brand">
            </div>
            <div class="form-group col-md-2 mb-3">
                <label for="inputModel">Model</label>
                <input type="text" class="form-control" id="inputModel" placeholder="Model" name="model">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-2 mb-3">
                <label for="inputBody">Body Type</label>
                <select id="inputBody" class="form-control" name="body">
                    <c:forEach items="${bodyStyles}" var="bodyStyles">
                        <option value="${bodyStyles}">${bodyStyles}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-2 mb-3">
                <label for="inputPrice">Price</label>
                <input class="form-control" type="number" min="0" step="100" max="100000000" id="inputPrice" name="price">
            </div>
        </div>
        <button type="submit" class="btn btn-primary mb-3">Add car</button>
    </form>
</div>
</body>
</html>
