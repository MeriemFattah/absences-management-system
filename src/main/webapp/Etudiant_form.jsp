<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Administration</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<style>
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
	 body {
        background-image: url("https://img.freepik.com/photos-premium/texte-bleu-fond-blanc-pour-rendu-3d-du-concept-education_35719-4149.jpg");
        background-size: 50%;
         background-repeat: no-repeat;
      	background-position : 700px 40px; 
		background-position : left;
		 
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
	</style>
    <div align="center">
    <c:if test="${user != null}">
    					<form action="Etudiant_servlet?action=update" method="post">
						</c:if>
					<caption>
							<h4 align="center" >
								<c:if test="${user != null}">
								</c:if>
        <h2 aligne="center">ENTER GRADES</h2>
        <table border="1" cellpadding="5" align="center" class="table table-bordered table-width float-end"> 
        		 <tr>
                <th>CNE: </th>
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
                <th>TP_Grades: </th>
                <td>
                	<input type="number" name="TP" size="45"
                			value="<c:out value='${user.TP}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Controle_Grades: </th>
                <td>
                	<input type="number" name="Controle" size="45"
                			value="<c:out value='${user.controle}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Examen_Grades: </th>
                <td>
                	<input type="number" name="examen" size="45"
                			value="<c:out value='${user.examen}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Course_name: </th>
                <td>
                	<input type="text" name="nom_module" size="45"
                			value="<c:out value='${user.nom_module}' />"
                		/>
                </td>
            </tr>
             <tr>
                <th>Classe_name: </th>
                <td>
                	<input type="text" name="nom_classe" size="45"
                			value="<c:out value='${user.nom_classe}' />"
                		/>
                </td>
            </tr>
             <tr>
            		<td colspan="2" align="center">
            		<input type="hidden" name="Tp" value='${user.TP}'>
            		<input type="hidden" name="Controle" value='${user.controle}'>
            		<input type="hidden" name="examen" value='${user.examen}'>
            			<button  class="btn btn-primary">Save</button>
            		</td>
            </tr>
        </table>
        
       </form>
     
    </div>
    <div class="container">		
   		<img alt="" class="img-thumbnail" src="images/travail.jpg" aligne="left" />
   	</div>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>