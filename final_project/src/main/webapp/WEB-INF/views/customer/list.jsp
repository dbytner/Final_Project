<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <h1><spring:message code="app.title"/></h1>
</head>
<body>
<h1>List</h1>
<table>
    <tr>
        <th>
            <form action="/customer/add">
                <input type="submit" value="Dodaj klienta" />
            </form>
        </th>
    </tr>
</table>
<table>
    <tr>
        <th>id</th>
        <th>nazwa</th>
        <th>email</th>
        <th>adres</th>
        <th>telefon</th>
        <th>nip</th>
        <th>konto</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td>${customer.phone}</td>
            <td>${customer.nip}</td>
            <td>${customer.bankAccount}</td>
            <td>
                <a href="/customer/delete-confirm/${customer.id}">delete</a>
                <a href="/customer/edit/${customer.id}">edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
