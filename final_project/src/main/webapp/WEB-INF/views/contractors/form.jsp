<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dodaj kontrahenta</title>
</head>
<body>
<h1>Dodaj kontrahenta</h1>
<table>
  <tr>
    <th>
      <form action="/contractors/list">
        <input type="submit" value="Lista kontrahentów" />
      </form>
    </th>
  </tr>
</table>
<form:form modelAttribute="contractors">
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
  osoba do kontaktów:
  <form:input path="poc"/><br/>
  <input type="submit">
</form:form>
</body>
</html>