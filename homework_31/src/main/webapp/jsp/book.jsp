<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <div class="row pt-2 col-6 pl-0">
        <form action="book" method="post">
            <input type="text" class="form-control" id="input" name="search_text">
            <button type="submit" class="btn btn-primary mb-2 col-2 mt-2">Search</button>
        </form>
    </div>

    <div class="row pt-3">
        <caption>Search results:</caption>
        <table class="table col-6">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Author</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${books}" var="book" varStatus="loop">
                <tr>
                    <th scope="row">${loop.count}</th>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <sf:form action="book/add" method="post" modelAttribute="book">
        <div class="row mt-10">
            <h3>Add new book</h3>
        </div>
        <div class="row mb-3 col-5">
            <label for="book_name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <sf:input path="name" class="form-control" id="book_name" name="book_name"/><sf:errors path="name"/>
            </div>
        </div>
        <div class="row mb-3 col-5">
            <label for="bookauthor" class="col-sm-2 col-form-label">Author</label>
            <div class="col-sm-10">
                <sf:input path="author" class="form-control" id="bookauthor" name="book_author"/><sf:errors
                    path="author"/>
            </div>
        </div>
        <sf:button class="btn btn-primary">Add book</sf:button>
    </sf:form>
</div>
</body>
</html>
