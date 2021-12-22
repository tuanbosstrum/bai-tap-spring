<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách người dùng</title>
</head>
<%@ page isELIgnored="false" %>
<body>
    <h1>Products</h1>
    <p><a href="/baitapcontrollerdemo/newcus">Thêm thông tin cá nhân</a></p>
    <p>There are ${custormers.size()} đã có trong danh sách.</p>
    <table border="1">
        <tr>
            <td>Mã khách</td>
            <td>Tên khách hàng</td>
            <td>Email</td>
        </tr>
        <c:forEach var="custormer" items="${custormers}">
            <tr>
                <td>${custormer.getId()}</td>
                <td><a href="viewcus?id=${custormer.getId()}"> ${custormer.getName()}</a></td>
                <td>${custormer.getEmail()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>