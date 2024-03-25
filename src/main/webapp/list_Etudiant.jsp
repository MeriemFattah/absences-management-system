<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Student Management Application</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<style>
body {
			background-color: #ECF0F1;
			font-family: Arial, sans-serif;
		}
h1{
  	color:#0A2BF9}
</style>
	<center>
	
		<h1>Student Management</h1>
		 <caption><h2>List of Students</h2></caption>
        <form action="STUDENTS?action=Majors_etudiant" method="post">
      		<label >Majors</label>
      		<select name="choix_etudiant">
        	<option value="IID1">IID1</option>
        	<option value="GI1">GI1</option>
        	<option value="IRIC1">IRIC1</option>
        	<option value="IID2">IID2</option>
        	<option value="GI2">GI2</option>
        	<option value="IRIC2">IRIC2</option>
      		</select>
      		<button  class="btn btn-primary">Enter</button>
		</form>
		<form action="STUDENTS?action=search_Etudiant" method="post">
			<input type="number" name="chercher" />
			<button  class="btn btn-primary">search_Etudiant</button>
		</form>
       
	</center>
	 
    <div align="center">
        <table border="1" cellpadding="5"  class="table table-striped-columns">
            <tr>
                <th>CNE</th>
                <th>CIN</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date of birthday</th>
                <th>City</th>
                <th>Street</th>
                <th>Country</th>
                <th>Postal code</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Classe_Name</th>
                 <th>Classe_ID</th>
                <th>Password</th>
                
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.CNE}" /></td>
                    <td><c:out value="${user.CIN}" /></td>
                    <td><c:out value="${user.nom}" /></td>
                    <td><c:out value="${user.prenom}" /></td>
                    <td><c:out value="${user.date_de_naissance}" /></td>
                    <td><c:out value="${user.ville}" /></td>
                    <td><c:out value="${user.rue}" /></td>
                    <td><c:out value="${user.pay}" /></td>
                    <td><c:out value="${user.code_postale}" /></td>
                    <td><c:out value="${user.email}" /></td> 
                    <td><c:out value="${user.sexe}" /></td>
                    <td><c:out value="${user.nomc}" /></td>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.mot_de_passe}" /></td>
                    <td>
                    	<form action="STUDENTS?action=edit_Etudiant" method="post">
                    		<input type="hidden" name="CNE" value="${user.CNE}" />
                    		<button  class="btn btn-primary">Edit</button> 
                    	</form>
                    	 <form action="STUDENTS?action=delete_Etudiant" method="post">
                    	 	<input type="hidden" name="CNE" value="${user.CNE}" />
                    		<button  class="btn btn-primary">Delete</button> 
                    	</form>             	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
   
</body>
</html>
