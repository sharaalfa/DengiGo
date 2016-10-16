<html lang="ru">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>RequestTypeForm</title>
</head>
<body>
<h1>Register Request Type</h1>
<form method="post">
    Title: <input type="text" value="${requestType.title}" name="title"/><br/>
    Description: <input type="text" value="${requestType.description}" name="description"/><br/>
    <input type="submit" value="Register"/>
    <a class="btn btn-danger" href="/requestType/list">Cancel</a>
</form>
</body>
</html>