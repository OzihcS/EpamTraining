<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Multiplication Table</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<table>
    <tr>
        <% for (int i = 0; i < 10; i++) {
            int result = i;%>
        <td><%=i%>
        </td>
        <%
            for (int j = 1; j < 10; j++) {
                if (i == 0) {
                    result = (i + 1) * j;
                } else
                    result = i * j;%>
        <td><%= result%>
        </td>
        <% } %>
    </tr>
    <% } %>
</table>
<hr>
<a href="home.jsp">Back</a>
</body>
</html>
