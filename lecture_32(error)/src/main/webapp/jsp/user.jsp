<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form action="user" method="post">--%>
<%--    Login <input type="text" name="login"/>${login}<br>--%>
<%--    Password <input type="password" name="password"/>${password}<br>--%>
<%--    <input type="submit" name="submit" value="Submit">--%>
<%--</form>--%>

<sf:form action="user" method="post" modelAttribute="user">
    Login: <sf:input path="login"/><sf:errors path="login"/><br>
    Password: <sf:password path="password"/><sf:errors path="password"/><br>
    <sf:button> Login </sf:button>

</sf:form>

</body>
</html>
