<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<form action="LoginServlet" method="post">
    <input type="text" name="login" placeholder="Login"/><br>
    <input type="password" name="pass" placeholder="Password"/><br>
    <input type="submit" value="login"> <input type="reset" value="Clear"><br>
    <p>${errorMsg}</p>
</form>
</body>
</html>
