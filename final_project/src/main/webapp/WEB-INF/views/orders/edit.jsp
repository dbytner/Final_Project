<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 04.07.2023
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja</title>
</head>
<body>
<form:form modelAttribute="orders" action="/orders/edit">
    <form:hidden path="id"/>
    nazwa:
    <form:input path="name"/><br/>
    <%--    <form:errors path="title"/><br/>--%>
    opis:
    <form:input path="description"/><br/>
    <%--    <form:errors path="pages"/><br/>--%>
    status:
    <form:input path="status"/><br/>
    <%--    <form:errors path="rating"/><br/>--%>

    <form:select itemLabel="name"
                 itemValue="id"
                 path="customer" items="${customers}"/><br/>
    <input type="submit">
</form:form>
</body>
</html>
