<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
