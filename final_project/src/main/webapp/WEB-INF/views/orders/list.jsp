<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 04.07.2023
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List</h1>
<table>
    <tr>
        <th>id</th>
        <th>nazwa</th>
        <th>opis</th>
        <th>utworzono</th>
        <th>zmodyfikowano</th>
        <th>status</th>
        <th>klient</th>
        <th>actions</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.name}</td>
            <td>${order.description}</td>
            <td>${order.created}</td>
            <td>${order.updated}</td>
            <td>${order.status}</td>
            <td>${order.customer.name}</td>
            <td>
                <a href="/orders/delete-confirm/${order.id}">delete</a>
                <a href="/orders/edit/${order.id}">edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>