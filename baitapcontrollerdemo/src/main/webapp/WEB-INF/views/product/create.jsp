<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<%@ page isELIgnored="false" %>
<body>
    <h1>Create new Product</h1>
    <a href="/baitapcontrollerdemo/products">Back to product list</a>
    <p>
      <c:if test="${message != null}">
          <span class="message">${message}</span>
      </c:if>
    </p>
    <form:form action="new" method="post" modelAttribute="product">
        <fieldset>
            <legend>Product information</legend>
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
                    <td><form:label path="price">Price:</form:label></td>
                    <td><form:input path="price"/> </td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:button>Create product</form:button> </td>
                </tr>
            </table>
        </fieldset>
    </form:form>
</body>
</html>