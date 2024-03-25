<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<meta charset="UTF-8">
<title>Attendance</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<style>

h1{
  	color:#0A2BF9}
</style>
<head>
	<title>Administration  </title>
</head>

	<center>
		<h1>Abscence Management</h1>
	</center>
    <div align="center">
        <caption><h2> Students 'List </h2></caption>
        <table border="1" cellpadding="5" class="table table-striped-columns">
            
            <tr>
            	<th>CNE</th>
                <th>First Name</th>
                <th>Last Name</th>
                 <th>Abscence's Number</th>
                <th>Sanction</th>
                <th>Actions</th>
              
                
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.CNE}" /></td>
                    <td><c:out value="${user.nom}" /></td>
                    <td><c:out value="${user.prenom}" /></td>
                     <td><c:out value="${user.abs}" /></td>
                   	<td><c:out value="${user.sanction}" /></td>
                    <td>
                    <form action="Absence?action=edit" method="post">
                   		<input type="hidden" name="CNE" value="${user.CNE}" />
   						<button class="btn btn-primary">edit</button>
					</form>
					 <form action="Absence?action=delete" method="post">
                  		<input type="hidden" name="CNE" value="${user.CNE}" />
   						<button class="btn btn-primary">delete</button>
                    </form>                  	
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </div>	

</body>
</html>