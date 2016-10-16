<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Hello Page</title>
</head>
<body>
Hello! Our first message: ${hello}
<c:set var="salary" scope="session" value="${2000*2}"/>
<c:if test="${salary > 2000}">
    <p>My salary is <c:out value="${salary}"/> </p>
</c:if>

<c:forTokens items="Nike, Zara, Adidas" delims="," var="name">
    <p><c:out value="${name}"/> </p>
</c:forTokens>

<s:url value="/" var="springUrl"/>
<c:url value="/" var="jstlUrl"/>
<a href="${springUrl}">URL</a>
<jsp:include page="test.jsp"/>
</body>
</html>