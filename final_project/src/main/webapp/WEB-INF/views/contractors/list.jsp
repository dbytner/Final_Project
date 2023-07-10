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
            <form action="/contractors/add">
                <input type="submit" value="Dodaj kontrahenta" />
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
    <c:forEach items="${contractors}" var="contractor">
        <tr>
            <td>${contractor.id}</td>
            <td>${contractor.name}</td>
            <td>${contractor.email}</td>
            <td>${contractor.address}</td>
            <td>${contractor.phone}</td>
            <td>${contractor.nip}</td>
            <td>${contractor.poc}</td>
            <td>
                <a href="/contractors/delete-confirm/${contractor.id}">delete</a>
                <a href="/contractors/edit/${contractor.id}">edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
