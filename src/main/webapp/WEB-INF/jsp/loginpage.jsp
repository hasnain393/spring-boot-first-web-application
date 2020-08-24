<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> enter yor informations</h2>

<h5>jsp page</h5>

<font color="red">${errorMessage}</font>

<form action="details" method="get">

<label>enter username:</label>
<input name="username" type="text"/>

<label>enter password:</label>
<input name="password" type="text"/>

<button>submit</button>

</form>


</body>
</html>