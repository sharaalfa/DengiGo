<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page2</title></head>
<body>
Hello my name <%= request.getAttribute("name")%>
Hello my description <%= request.getAttribute("description")%>

</body>
</html>