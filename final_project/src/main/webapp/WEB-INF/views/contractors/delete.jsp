<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Czy na pewno chcesz usunąć???</p>
<a href="/contractors/delete/${contractors.id}">Confirm</a>
<a href="/contractors/list/">Cancel</a>
</body>
</html>
