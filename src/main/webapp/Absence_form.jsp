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
 body {
        
		 
      }
      table{
      position: relative;
  	right: 40px;
  	top:70px;}
  	h4{
  	color:#0A2BF9}
  	th{
  	color:#0A2BF9
  	}
  	h1{
  	color:#0A2BF9}
  	body {
        background-image: url("https://koesio.com/wp-content/uploads/2022/04/conges.jpg");
        background-size: 50%;
         background-repeat: no-repeat;
         background-position : 750px 350px; 
		background-position : buttom ;
      
		 
      }
	</style>
<center>
	<h1>Abscence Management</h1>
</center>
    <div align="center">
		<c:if test="${user != null}">
			<form action="Absence?action=update" method="post">
        </c:if>
        <table border="1" cellpadding="5" >
            <caption>
            	<h2>
            		<c:if test="${user != null}">
            		</c:if>
            		<c:if test="${user == null}">
            		</c:if>
            		
            	</h2>
            </caption>
        		<c:if test="${user != null}">
        			<input type="hidden" name="ida" value="<c:out value='${user.ida}' />" />
        		</c:if>     
        		 <tr>
                <th>Student'Id: </th>
                <td>
                	<input type="number" name="CNE" size="45"
                			value="<c:out value='${user.CNE}' />"
                		/>
                </td>
            </tr>       
            <tr>
                <th>First Name: </th>
                <td>
                	<input type="text" name="nom" size="45"
                			value="<c:out value='${user.nom}' />"
                		/>
                </td>
            </tr>
             <tr>
                <th>Last Name: </th>
                <td>
                	<input type="text" name="prenom" size="45"
                			value="<c:out value='${user.prenom}' />"
                		/>
                </td>
            </tr>
               <tr>
                <th>Abscence'Number </th>
                <td>
                	<input type="number" name="abscence" size="45"
                			value="<c:out value='${user.abs}' />"
                		/>
                </td>
             </tr>
               <tr>
                <th>Sanction </th>
                <td>
                	<input type="text" name="sanction" size="45"
                		value="<c:out value='${user.sanction}' />"/>
                </td>
            </tr>
             
         
      
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" class="btn btn-primary" />
            	</td>
            </tr>
        </table>
       
    </div>	

</body>
</html>