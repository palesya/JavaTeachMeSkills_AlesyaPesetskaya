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

<div class="container">
    <nav class="navbar navbar-dark justify-content-center" style="background-color: #5F9EA0">
        <a class="navbar-brand fst-italic">
            <s:message code="label.title"/>
        </a>
        <div class="dropdown">
            <button class="btn dropdown-toggle border-white border-2" style="background-color: #008B8B" type="button"
                    id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                <s:message code="label.select_language_button"/>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/book?lang=en">English</a></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/book?lang=ru">Русский</a></li>
            </ul>
        </div>
    </nav>
</div>


<div class="container">
    <div class=row>
        <div class=col-4>
            <img src="https://st.depositphotos.com/1741875/1237/i/600/depositphotos_12376816-stock-photo-stack-of-old-books.jpg"
                 class="rounded float-left" width="100%" height="auto">
        </div>
        <div class=col-6>
            <div class="row pt-4 pl-0">
                <form action="${pageContext.request.contextPath}/book" method="post">
                    <input type="text" class="form-control" id="input" name="search_text">
                    <button type="submit" class="btn btn-primary mb-2 col-2 mt-2">
                        <s:message code="label.search_button"/>
                    </button>
                </form>
            </div>

            <div class="row pt-3">
                <caption>
                    <s:message code="label.title_results"/>
                </caption>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">
                            <s:message code="label.name_header"/>
                        </th>
                        <th scope="col">
                            <s:message code="label.author_header"/>
                        </th>
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
            <sf:form action="${pageContext.request.contextPath}/book/add" method="post" modelAttribute="book">
                <div class="row mt-10">
                    <h3><s:message code="label.add_book_title"/></h3>
                </div>
                <div class="row mb-3">
                    <label for="book_name" class="col-sm-2 col-form-label"><s:message code="label.name_header"/></label>
                    <div class="col-sm-10">
                        <sf:input path="name" class="form-control" id="book_name" name="book_name"/><sf:errors
                            path="name"/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="bookauthor" class="col-sm-2 col-form-label"><s:message code="label.author_header"/></label>
                    <div class="col-sm-10">
                        <sf:input path="author" class="form-control" id="bookauthor" name="book_author"/><sf:errors
                            path="author"/>
                    </div>
                </div>
                <sf:button class="btn btn-primary"><s:message code="label.add_book_button"/></sf:button>
            </sf:form>
            ${error}
        </div>
    </div>
</div>
</body>
</html>
