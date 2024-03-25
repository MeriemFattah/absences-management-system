<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<style>

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
	h2 {
		color:#0A2BF9;
	}

</style>
<center>
	<h1>Course Management</h1>
</center>
	<left>
		
         <form action="courses?action=new" method="post">
   				 <button class="btn btn-primary">Add New Course</button>
		</form>
	</left>
    <div align="center">
    <caption><h2>List of Courses</h2></caption>
        <table border="1" cellpadding="5" class="table table-striped-columns">
            <tr>
                <th>Course'Id</th>
                <th>Course'Name</th>
                <th>Professor'Id</th>
                 <th>Professor'Name</th>
                  <th>Professor'Last Name</th>
                   <th>Actions</th>
           
                
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.nom}" /></td>
                    <td><c:out value="${user.CNI}" /></td>
                    <td><c:out value="${user.n}" /></td>
                    <td><c:out value="${user.p}" /></td>
                    <td>
                    <form action="courses?action=edit" method="post">
                   		<input type="hidden" name="id" value="${user.id}" />
   						<button class="btn btn-primary">edit</button>
					</form>
					 <form action="courses?action=delete" method="post">
                  		<input type="hidden" name="id" value="${user.id}" />
   						<button class="btn btn-primary">delete</button>
                    </form>  	                 	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>