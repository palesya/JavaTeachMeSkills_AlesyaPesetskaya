<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="_nav.jsp"/>

<form method="get" action="/webAlesya/user">
    Login: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    <button>Enter</button>
</form>
<h1>Hello from jsp</h1>
</body>
</html>
