<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Administration</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<style>
	nav {
		background-color: #F4F6F6;
	}

	ul {
		list-style-type: none;
		margin: 0;
		padding: 0;
	}

	nav li {
		display: inline-block;
		margin-right: 10px;
	}

	

	

	body {
		background-color: #ECF0F1;
	}

	input[type="submit"] {
		background-color: #3498DB;
		color: white;
		border: none;
		cursor: pointer;
	}

	table {
		background-color: white;
	}

	table th, table td {
		padding: 5px;
	}

	table th {
		background-color: #3498DB;
		
	}

	table td a {
		color: #3498DB;
	}

</style>
<body>
<left>
	<nav>
		<ul>
			<form action="PROFESSORS_SPACE?action=ajouter" method="post">
			<li><b><button class="btn btn-primary">Add New Professors</button></b></li>
			</form>
		</ul>
	</nav>
</left>
&nbsp;&nbsp;&nbsp;
<div align="center">
	<form action="PROFESSORS_SPACE?action=enter" method="post">
		<label>Majors</label>
		<select name="choix">
			<option value="IID1">IID1</option>
			<option value="GI1">GI1</option>
			<option value="IRIC1">IRIC1</option>
			<option value="IID2">IID2</option>
			<option value="GI2">GI2</option>
			<option value="IRIC2">IRIC2</option>
		</select>
		<button class="btn btn-primary"/>enter </button>
	</form>

	<form action="PROFESSORS_SPACE?action=search" method="post">
		<input type="number" name="chercher"  />
		<button class="btn btn-primary"/>search</button>
	</form>
</div>


<center>
	<h4>list All professors</h4>
</center>
<table border="1" cellpadding="5" class="table table-striped-columns">
	<thead>
	<tr>
		<th>CIN</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Date of birthday</th>
		<th>City</th>
		<th>Street</th>
		<th>Country</th>
		<th>Postal code</th>
		<th>Email</th>
		<th>State</th>
		<th>Status</th>
		<th>Grades</th>
		<th>Password</th>
		<th>Actions</th>
            </tr> 
             </thead>  
            <c:forEach var="user" items="${listUser}">
             	<tbody >
                <tr>
                    <td><c:out value="${user.CNI}" /></td>
                    <td><c:out value="${user.nom}" /></td>
                    <td><c:out value="${user.prenom}" /></td>
                    <td><c:out value="${user.date_de_naissance}" /></td>
                    <td><c:out value="${user.ville}" /></td>
                    <td><c:out value="${user.rue}" /></td>
                    <td><c:out value="${user.pay}" /></td>
                    <td><c:out value="${user.code_postale}" /></td>
                    <td><c:out value="${user.email}" /></td>
                   
                    <td><c:out value="${user.etat}" /></td>
                    <td><c:out value="${user.statut}" /></td>
                    <td><c:out value="${user.grades}" /></td>
                    <td><c:out value="${user.mot_de_passe}" /></td>
                    <td>
                    <form action="PROFESSORS_SPACE?action=show" method="post">
                    <input type="hidden" name="CNI" value="${user.CNI}" >
                    	<button class="btn btn-primary">Edit</button>
                    </form>
                    	                  	
                    </td>
                </tr>
          
              </tbody>
            </c:forEach>
            
        </table>
        
</body>
</html>