<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Part3</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<form action="Part3" method="post">
    Input Name: <input type="text" name="name" autofocus> <input
        type="submit" value="Send">
</form>
<br>
<br>
<br>
<table border="1">
    <caption>All Names</caption>
    <c:forEach items="${names}" var="name">
        <tr>
            <td><c:out value="${name}" /></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="Part3?action=remove">Clear result list</a>
<hr>
<a href="home.jsp">Back</a>
</body>
</html>
