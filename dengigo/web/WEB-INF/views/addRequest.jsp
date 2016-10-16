<html lang="ru">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <title>Request</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css" rel="stylesheet" >
</head>
<body>

<script src="js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/i18n/defaults-*.min.js"></script>

<form action="addRequest" method="post" >
    <style>
        p {
            margin-top: 0.5em; /* Отступ сверху */
            margin-bottom: 1.5em; /* Отступ снизу */
            text-align: right;
            font-weight: 600;
        }
    </style>

    <div class="panel panel-default">
        <div class="panel-heading">ДеньгиGo</div>
        <div class="panel-body">Создание запроса</div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>Название</p>
        </div>

        <div class="col-sm-4">
            <input name="name" class="form-control" id="name" placeholder="Название запроса"/>
        </div>

        <div class="col-sm-2">
            <p>Тип запроса</p>
        </div>

        <div class="col-sm-3">
            <select name="typerequest" class="selectpicker">
                <option>ИТ</option>
                <option>Бухгалтерия</option>
                <option>Кадры</option>
            </select>
        </div>

    </div>


    <div class="row">
        <div class="col-sm-2">
            <p>Описание</p>
        </div>

        <div class="col-sm-4">
            <input name = "description" class="form-control" id="description" placeholder="Описание запроса">
        </div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>Создатель</p>
        </div>

        <div class="col-sm-4">
            <input name = "creator" class="form-control" id="creator" placeholder="Создатель запроса">
        </div>

        <div class="col-sm-2">
            <p>Редактор</p>
        </div>

        <div class="col-sm-3">
            <input name = "editor" class="form-control" id="editor" placeholder="Редактор">
        </div>

    </div>






    <div class="row">
        <div class="col-sm-2">
            <p>Дата создания</p>
        </div>

        <div class="col-sm-4">
            <input name = "datacreator" class="form-control" id="datacreator" placeholder="Дата создания">
        </div>

        <div class="col-sm-2">
            <p>Дата редактирования</p>
        </div>

        <div class="col-sm-3">
            <input name = "editcreator" class="form-control" id="editcreator" placeholder="Дата редактирования">
        </div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <p>Исполнитель</p>
        </div>

        <div class="col-sm-4">
            <select name="performer" class="selectpicker">
                <option>Иванов</option>
                <option>Петров</option>
                <option>Сидоров</option>
            </select>
        </div>
    </div>

    <div class="panel-body"></div>
    <div class="panel-body"></div>

    <div class="row">
        <div class="col-sm-2 col-sm-offset-1">
            <button type="submit" class="btn btn-success">ОК</button>
        </div>
        <div class="col-sm-4"></div>

        <div class="col-sm-1">
            <button class="btn btn-danger">Отмена</button>
        </div>

    </div>



</form>




</body>
</html>