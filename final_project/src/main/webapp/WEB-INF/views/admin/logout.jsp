<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 19.07.2023
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/logout"/>" method="post">
  <input class="fa fa-id-badge" type="submit" value="Wyloguj">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
