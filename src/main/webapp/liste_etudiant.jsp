<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Administration</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<script src="js1.js"></script>
</head>

<body>

    <style>
    	body{
    	background-color: #ECF0F1;
    	}
        .table-width {
            max-width: 500px;
        }
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
        table {
            position: relative;
            right: 0px;
            top: 70px;
        }
        h4 {
            color: #0A2BF9;
        }
        th {
            color: #0A2BF9;
        }
    </style>



      	<center>
      	  <h4 >list All Students</h4>
      	  
      	  </center>
      
        <table border="1" cellpadding="5" class="table table-striped-columns">
             <thead>
            <tr>
                <th>CNE</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>TP_Grades</th>
                <th>Controle_Grades</th>
                <th>Examen_Grades</th>
                <th>Course_Name</th>
                <th>Classe_Name</th>
                <th>Action</th>
            </tr> 
             </thead>  
            <c:forEach var="user" items="${listUser}">
             	<tbody >
                <tr>
                    <td><c:out value="${user.CNE}" /></td>
                    <td><c:out value="${user.nom}" /></td>
                    <td><c:out value="${user.prenom}" /></td>
                    <td><c:out value="${user.TP}" /></td>
                    <td><c:out value="${user.controle}" /></td>
                    <td><c:out value="${user.examen}" /></td>
                    <td><c:out value="${user.nom_module}" /></td>
                    <td><c:out value="${user.nom_classe}" /></td>
                    <td>
                    
      					<form action="Etudiant_servlet?action=edit" method="post">
                     <input type="hidden" name="CNE" value="${user.CNE}">
                    	 <input type="hidden" name="nom_module" value="${user.nom_module}">
                    	 <input type="hidden" name="nom_classe" value="${user.nom_classe}">
                    	 <button class="btn btn-primary">Edit </button> 
                    	 </form>
                    </td>
                </tr> 				
              </tbody>
            </c:forEach>
            
        </table>
   


</body>

</html>