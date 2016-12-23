<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Favorite sport</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<form action="MyServlet" method="post">
    <tr>
        <td>
            <select name="select">
                <%
                    List<String> names = (List<String>) request.getAttribute("names");
                    for (String name : names) {
                %>
                <option name="<%=name%>"><%=name%>
                </option>
                <%
                    }
                %>
            </select>
        </td>
        <td>
            <input name="userName" type="text">
        </td>
    </tr>
    <input type="submit" value="Vote">
</form>
</body>
</html>