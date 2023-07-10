<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja kontrahenta</title>
</head>
<body>
<form:form modelAttribute="contractors" action="/contractors/edit">
    <form:hidden path="id"/>
    nazwa:
    <form:input path="name"/><br/>
    email:
    <form:input path="email"/><br/>
    adres:
    <form:input path="address"/><br/>
    telefon:
    <form:input path="phone"/><br/>
    NIP:
    <form:input path="nip"/><br/>
    osoba do konatktów:
    <form:input path="poc"/><br/>
    <input type="submit">
</form:form>
</body>
</html>
