<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC 5 - form handling | Java Guides</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
  
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Add hobby</div>
    </div>
    <div class="panel-body">
     <form:form action="saveHobby" cssClass="form-horizontal"
      method="post" modelAttribute="hobby">

      <!-- need to associate this data with customer id -->
      <form:hidden path="id" />

      <div class="form-group">
       <label for=name class="col-md-3 control-label">
        Name</label>
       <div class="col-md-9">
        <form:input path="name" cssClass="form-control" />
        <form:errors path="name" cssClass="error"/> 
       </div>
      </div>
   

      

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
 <script src="//code.jquery.com/jquery.js"></script>
<!-- Bootstrap JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>