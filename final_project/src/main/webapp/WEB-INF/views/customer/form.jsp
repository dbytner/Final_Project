<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dodaj klienta</title>
</head>
<body>
<h1>Dodaj klienta</h1>
<table>
  <tr>
    <th>
      <form action="/customer/list">
        <input type="submit" value="Lista klientów" />
      </form>
    </th>
  </tr>
</table>
<form:form modelAttribute="customers">
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
  konto:
  <form:input path="bankAccount"/><br/>
  <input type="submit">
</form:form>
</body>
</html>