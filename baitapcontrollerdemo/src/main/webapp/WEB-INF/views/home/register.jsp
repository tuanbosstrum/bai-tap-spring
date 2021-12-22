<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTER</title>
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<%@ page isELIgnored="false" %>
<body>
    <h1>REGISTER</h1>
    <p>
      <c:if test="${message != null}">
          <span class="message">${message}</span>
      </c:if>
    </p>
    <form:form action="register" method="post" modelAttribute="user">
        <fieldset>
            <table>
             
                <tr>
                    <td><form:label path="username">Username:</form:label></td>
                    <td><form:input path="username"/> </td>
                </tr>
                <tr>
                    <td><form:label path="password">Password:</form:label></td>
                    <td><form:input path="password"/> </td>
                </tr>
                <tr>
                    <td><label>Repassword:</label></td>
                    <td><input type="text" name="repassword"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:button>Create</form:button> </td>
                </tr>
            </table>
        </fieldset>
    </form:form>
     <a href="login">Login</a>
</body>
</html>
