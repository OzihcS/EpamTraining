<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Multiplication Table</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<table>
    <c:forEach var="i" begin="0" end="9">
        <tr>
            <td><c:out value="${i}"/></td>
            <c:forEach var="j" begin="1" end="9">
                <td>
                    <c:if test="${i == 0}">
                        <c:out value="${(i+1) * (j)}"/>
                    </c:if>
                    <c:if test="${i != 0}">
                        <c:out value="${i * (j)}"/>
                    </c:if>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<hr>
<a href="home.jsp">Back</a>
</body>
</html>

