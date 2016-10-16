<html lang="ru">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <title>Request</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css"
          rel="stylesheet">
</head>


<body>

<div class="panel panel-default">
    <div class="panel-heading">ДеньгиGo</div>
    <div class="panel-body">List of Request Types</div>
</div>

<br/>
<a class="btn btn-success" href="/requestType/add">NEW</a>
<br/>
<table>
    <tr>
        <th style="width: 3%">X</th>
        <th style="width: 3%">?</th>
        <th style="width: 5%">id</th>
        <th style="width: 20%">Название</th>
        <th style="width: 45%">Описание</th>

        <th style="width: 10%">Создано</th>
        <th style="width: 10%">Обновлено</th>
    </tr>

    <c:forEach items="${requestTypes}" var="list" step="1">
        <tr class="row2">
            <td><a href="/requestType/${list.id}/delete"> X </a></td>
            <td><a href="/requestType/${list.id}"> ? </a></td>
            <td><c:out value="${list.id}"/> </a></td>
            <td><c:out value="${list.title}"/></td>
            <td><c:out value="${list.description}"/></td>
            <td><c:out value="${list.createdDate}"/></td>
            <td><c:out value="${list.updatedDate}"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>