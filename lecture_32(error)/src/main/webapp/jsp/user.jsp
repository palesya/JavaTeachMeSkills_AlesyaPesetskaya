<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sf:form action="user" method="post" modelAttribute="user">
    Login <sf:input path="login"/>${error}<br>
    Password <sf:password path="password"/><sf:errors path="password"/><br>
    <sf:button>Login</sf:button><br>
</sf:form>

<sf:form action="file" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/><br>
    <input type="submit"/>
</sf:form>
${file}
</body>
</html>
