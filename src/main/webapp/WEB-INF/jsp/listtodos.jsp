<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
 <h2>welcome     ${user } </h2>
 
 <div class="container">
 <table class=" table table-striped">
 
 <tr>
 <th>id</th>
 <th>name</th>
 <th>desctiption</th>
 <th>date</th>
 <th>done</th>
 <th>action</th>
 </tr>
 <c:forEach var="todo" items="${alltodos}">
 
 <c:url var="deleteLink" value="/delete">
								<c:param name="todoId" value="${todo.id}" />
									<c:param name="todoname" value="${todo.user}" />
							</c:url> 

		
		

 
 <tr>
 <td> ${todo.id} </td>
 <td> ${todo.user} </td>
 <td> ${todo.desc} </td>
 <!-- to display date in a particular format acroos the application -->
 <td><fmt:formatDate value="${todo.targetDate}" pattern="dd-MM-yyyy"></fmt:formatDate> </td>
 <td> ${todo.done} </td>
 
 <td>
									
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
									
									| <a href="/updatetodo?todoId=${todo.id} ">Update</a>
								</td>
 </tr>
  </c:forEach> 
 </table>
 
        
   
   <p>Add new  <a href="/addtodo" class="btn btn-primary"> todo</a></p>   
    </div>  
    
    <br>
    <!-- logout functionality -->
<a href="/logout">logout</a>
</body>
</html>