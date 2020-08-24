<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
your username is :  ${user }

click here to  manage your <a href="/list">todos</a> 

<br>

<!-- logout functionality -->
<a href="/logout">logout</a>
</body>
</html>