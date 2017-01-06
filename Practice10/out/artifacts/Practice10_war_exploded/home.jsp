<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="main">
    You are logged as :
    <c:out value="${sessionScope.User.getRole().getName()}"/>
    <c:out value="${sessionScope.User.getLogin()}"/>
</div>
<a href="multiplication-table.jsp">Part1</a>
<br>
<a href="mult-table.jsp">Part2</a>
<br>
<a href="task3.jsp">Part3</a>
<br>
<a href="task4.jsp">Part4</a>
<br>
</body>
</html>
