<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>javaguides.net</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<style>
.error-message {
	color: red;
	font-weight: 500;
	font-style: italic;
}
</style>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">Spring MVC 5 + Hibernate 5 + JPA + MySQL
				Example</h2>
			<div class="panel-body">
				<form:form action="saveCustomer" cssClass="form-horizontal"
					method="post" modelAttribute="customer">
					<form:hidden path="id" />
					<div class="form-group">
						<label for="fullName" class="col-md-3 control-label">Họ
							tên</label>
						<div class="col-md-9">
							<form:input path="fullName" cssClass="form-control" />
							<form:errors path="fullName" cssClass="error-message" />
						</div>
					</div>
					<br>
					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<form:button class="btn btn-primary">Thêm</form:button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>