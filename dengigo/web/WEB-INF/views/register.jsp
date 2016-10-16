<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <s:url var="authUrl" value="/j_spring_security_check"/>
    <form class="form-signin" action="/register" method="post">
        <h2 class="form-signin-heading">Регистрация</h2>

        <label for="inputEmail" class="sr-only">Эл. почта</label>
        <input name="username" id="inputEmail" class="form-control" placeholder="Эл. почта" required autofocus/>

        <label for="inputFIO" class="sr-only">Ф.И.О</label>
        <input name="fio" type="fio" id="inputFIO" class="form-control" placeholder="Ф.И.О" required>


        <label for="inputPassword" class="sr-only">Пароль</label>
        <input name="Password" type="password"  id="inputPassword" class="form-control" placeholder="Пароль" required/>

        <label for="confirmPassword" class="sr-only">Подтверждение пароля</label>
        <input name="confirmPassword" type="password" id="confirmPassword" class="form-control" placeholder="Подтверждение пароля" required/>

        <div class="dropdown">
            <button class="btn btn-default dropdown-toggle form-control" type="button" id="menu1" data-toggle="dropdown">Выбрите роль
                <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="#">Сотрудник</a></li>
                <li><a href="#">Менеджер</a></li>
            </ul>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Зрегистрироваться</button>
        <a class="btn btn-lg btn-info btn-block" href="/register">Отмена</a>

    </form>

</div> <!-- /container -->