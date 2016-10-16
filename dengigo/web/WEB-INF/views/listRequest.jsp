<html lang="ru">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <title>Request</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css" rel="stylesheet" >
</head>


<body>

<style>
    table {
        width: 100%;
    }
    th {
        font-size: 13px;
        font-weight: normal;
        background: #b9c9fe;
        border-top: 4px solid #aabcfe;
        border-bottom: 1px solid #fff;
        color: #039;
        padding: 8px;
    }
    td {
        background: #e8edff;
        border-bottom: 1px solid #fff;
        color: #669;
        border-top: 1px solid transparent;
        padding: 8px;
    }
    tr:hover td {
        background: #ccddff;
    }
</style>


<div class="panel panel-default">
    <div class="panel-heading">ДеньгиGo</div>
    <div class="panel-body">Список запросов</div>
</div>

<table>
    <tr>
        <th style="width: 3%">№</th>
        <th style="width: 8%">Статус</th>
        <th style="width: 20%">Название</th>
        <th style="width: 45%">Описание</th>
        <th style="width: 8%">Тип</th>

        <th style="width: 8%">Создано</th>
        <th style="width: 8%">Обновлено</th>
    </tr>

    <c:forEach items="${listRequests}" var="lists" step="1">
        <tr class="row2">
            <td>  <a href="/addRequestPerformer?idRequest=${lists.requestId}"> <c:out value="${lists.requestId}" /> </a></td>
            <td>  <c:out value="${lists.status}"/></td>
            <td>     <c:out value="${lists.title}"/></td>
            <td>     <c:out value="${lists.description}"/></td>
            <td>     <c:out value="${lists.requestType.title}"/></td>
            <td>     <c:out value="${lists.createdDate}"/></td>
            <td>     <c:out value="${lists.updatedDate}"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>