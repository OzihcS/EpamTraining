<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<form action="Calc" method="post">
    <table>
        <tr>
            <td><input name="x" value="0"></td>
        </tr>
        <tr>
            <td><input name="y" value="0"></td>
        </tr>
        <tr>
            <td>
                <select name="operation">
                    <option value="+">+</option>
                    <option value="-">-</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Calculate">
            </td>
        </tr>
    </table>
</form>
</body>
</html>