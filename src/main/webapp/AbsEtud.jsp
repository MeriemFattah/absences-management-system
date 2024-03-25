<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
	<title>Administration Management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<style>

h1{
  	color:#0A2BF9}
</style>
	<center>
        <h2>
        	<h1>Abscence Management</h1>
        	  <caption><h2>Students'List</h2></caption>
	</center>
    <div align="center">
    <form action="UserServlet?action=fill" method="post">
        <table border="1" cellpadding="5" class="table table-striped-columns">
          
            <tr>
                <th>Student'Id</th>
                 <th>First Name</th>
                <th>Last Name</th>
                 <th>Your Sanctions</th>
           
                
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.cne}" /></td>
                    <td><c:out value="${user.nom}" /></td>
                    <td><c:out value="${user.prenom}" /></td>
                     <td><c:out value="${user.sanction}" /></td>
                </tr>
            </c:forEach>
        </table>
        </form>
        
    </div>	
</body>
</html>