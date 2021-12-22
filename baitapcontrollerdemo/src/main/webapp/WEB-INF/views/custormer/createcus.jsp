<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm người dùng</title>
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<%@ page isELIgnored="false" %>
<body>
    <h1>Thông tin người dùng</h1>
    <a href="/baitapcontrollerdemo/custormers">Quay lại!</a>
    <p>
      <c:if test="${message != null}">
          <span class="message">${message}</span>
      </c:if>
    </p>
    <form:form action="newcus" method="post" modelAttribute="custormer">
        <fieldset>
            <legend>Thông tin người dùng</legend>
            <table>
                <tr>
                    <td><form:label path="code">Code:</form:label></td>
                    <td><form:input path="code"/> </td>
                </tr>
                <tr>
                    <td><form:label path="name">Name:</form:label></td>
                    <td><form:input path="name"/> </td>
                </tr>
                <tr>
                    <td><form:label path="email">Email:</form:label></td>
                    <td><form:input path="email"/> </td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:button>Nhập thông tin</form:button> </td>
                </tr>
            </table>
        </fieldset>
    </form:form>
</body>
</html>