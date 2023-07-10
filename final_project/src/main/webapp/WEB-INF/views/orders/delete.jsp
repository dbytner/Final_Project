<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 04.07.2023
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Czy na pewno chcesz usunąć???</p>
    <a href="/orders/delete/${orders.id}">Confirm</a>
    <a href="/orders/list/">Cancel</a>
</body>
</html>
