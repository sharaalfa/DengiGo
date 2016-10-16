<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<spring:form  method="post" modelAttribute="user" action="second" name="info-form">

    Name: <spring:input path="name"/><br/>
    Email: <spring:input path="email"/><br/>
    <spring:button>Next Page</spring:button>
</spring:form>