<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Administration Management</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

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
            top: 15px;
        }
        h4 {
            color: #0A2BF9;
        }
        th {
            color: #0A2BF9;
        }
    </style>



   


	<center>
        <h2>
        	<h1>Abscence Management</h1>
        	 <caption><h2>Students'List</h2></caption>
	</center>
    <div align="center">
        <table border="1" cellpadding="5"  class="table table-striped-columns">
            <tr>
                <th>Student'Id</th>
                <th>Student's Name</th>
                <th>Last Name</th>
                <th>Course'Name</th>
                <th>Major'Name</th>
            
                   <th>Actions</th>
           
                
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.CNE}" /></td>
                    <td><c:out value="${user.nom}" /></td>
                    <td><c:out value="${user.prenom}" /></td>
                     <td><c:out value="${user.nom_classe}" /></td>
                      <td><c:out value="${user.nom_module}" /></td>
                    <td>
                    <form action="UserServlet?action=fill" method="post">
                    <input type="hidden"name="CNE" value="${user.CNE}">
                    	 <input type="hidden" name="nom_module" value="${user.nom_module}">
                    	 <input type="hidden" name="nom_classe" value="${user.nom_classe}">
                    	<button class="btn btn-primary">Fill The Abscence </button>	 
                    	</form>                 	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    <div><form action="UserServlet?action=close" method="post"><center> <button class="btn btn-primary">Close</button></center></form></div>
</body>
</html>