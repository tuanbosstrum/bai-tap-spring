<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách người dùng</title>
</head>
<%@ page isELIgnored="false" %>
<body>
    <h1>Danh sách người dùng</h1>
    <a href="/baitapcontrollerdemo/custormers">Quay lại!</a>
    <table>
        <tr>
            <td>Code: </td>
            <td>${custormer.getCode()}</td>
        </tr>
        <tr>
            <td>Name: </td>
            <td>${custormer.getName()}</td>
        </tr>
        <tr>
            <td>Email: </td>
            <td>${custormer.getEmail()}</td>
        </tr>
    </table>
</body>
</html>