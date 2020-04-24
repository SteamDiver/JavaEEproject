<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h2>Welcome to JSP</h2>
<c:forEach items="${employees}" var="employee">
    <div>
        <h3>Name: ${employee.name}</h3>
        <p>Hired At: ${employee.hiredAt}</p>
        <p>Department: ${employee.department.name}</p>
    </div>
</c:forEach>
</body>
</html>
