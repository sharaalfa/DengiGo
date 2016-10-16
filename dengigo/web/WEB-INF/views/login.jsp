<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <c:choose>
        <c:when test="${not empty error}">
            <div class="error">${error}</div>
        </c:when>
        <c:otherwise>
            <h2 class="form-signin-heading">Добро пожаловать!</h2>
        </c:otherwise>
    </c:choose>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
    <s:url var="authUrl" value="/j_spring_security_check"/>
    <form class="form-signin" action="${authUrl}" method="post">
        <h2 class="form-signin-heading">ДеньгиGo</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input name="j_username" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="j_password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
            <label>
                <%--<input type="checkbox" id="j_remember" name="_spring_security_remember_me" > Remember me--%>
                <input type="checkbox" id="j_remember" name="remember-me" > Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>
        Напомнить пароль
        <a class="btn btn-lg btn-info btn-block" href="/register">Регистрация</a>
    </form>

</div> <!-- /container -->