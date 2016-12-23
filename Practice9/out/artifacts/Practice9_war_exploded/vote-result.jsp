<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Voting results</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<table border="1">
    <tr>
        <td>${names.get(0)}</td>
        <td>${footballCounter}</td>
        <td>
            <c:forEach items="${map}" var="entry">
                <c:if test="${entry.value == 'Football'}">
                    "${entry.key}"
                </c:if>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <td>${names.get(1)}</td>
        <td>${biathlonCounter}</td>
        <td>
            <c:forEach items="${map}" var="entry">
                <c:if test="${entry.value == 'Biathlon'}">
                    "${entry.key}"
                </c:if>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <td>${names.get(2)}</td>
        <td>${basketballCounter}</td>
        <td>
            <c:forEach items="${map}" var="entry">
                <c:if test="${entry.value == 'Basketball'}">
                    "${entry.key}"
                </c:if>
            </c:forEach>
        </td>
    </tr>
</table>
<hr/>
<a href='http://localhost:8080/Practice9/MyServlet'>Back</a>
</body>
</html>
