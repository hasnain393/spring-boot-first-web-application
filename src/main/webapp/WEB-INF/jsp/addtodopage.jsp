<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

</head>
<body>
	Welcome
	<b>${user}</b>
	
	
	
	
	<div class=container>
		<form:form method="post" modelAttribute="todo"
			onsubmit="return validate()">

			<form:hidden path="id" />

			<fieldset class="form-group">
				<form:label path="desc">Enter Description:</form:label>
				<form:input path="desc" id="desc" class="form-control"></form:input>
				<form:errors path="desc" cssClass="text-warning"></form:errors>
				<fieldset>

					<fieldset class="form-group">
						<form:label path="targetDate" >Enter Date:</form:label>
						<form:input path="targetDate"  class="form-control"></form:input>
						<form:errors path="targetDate" cssClass="text-warning"></form:errors>
						<fieldset>

							<form:button class="btn btn-primary">submit</form:button>
		</form:form>
	</div>

<!-- logout functionality -->
<a href="/logout">logout</a>
	

	<style>
.error {
	position: fixed, text-color:red;
}
</style>

	<script>
	
			$('#targetDate').datepicker({
				format : 'dd-mm-yyyy'
			});	
	
	/* 
	
		function validate() {
			var name = document.getElementById("desc").value;

			if (name !== null && name !== '') {

				return true;
			} else {
				
				alert("enter some value");

				return false;
			}

		} */
	</script>
</body>
</html>