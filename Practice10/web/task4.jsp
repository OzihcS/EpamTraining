<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rename</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<form action="Rename" method="post">
    Current name: <c:out value="${sessionScope.User.getName()}"/><br>
    New name: <input type="text" name="newName" placeholder="Name"/><br>
    <input type="submit" value="Rename"><br>
    <input type="hidden" name="login" value="${sessionScope.User.getLogin()}"/><br>
    <input type="hidden" name="password" value="${sessionScope.User.getPassword()}"/><br>
    <p>${infoMsg}</p>
</form>
<hr>
<a href="home.jsp">Back</a>
</body>
</html>
