<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
	<center>
		<h1>Students Management</h1>
        <h2>
        	<form action="STUDENTS?action=list_Etudiant" method="post">
              <button  class="btn btn-primary">List All Students</button>    
            </form>
        </h2>
	</center>
    <div align="center">
		<c:if test="${user != null}">
			<form action="STUDENTS?action=update_Etudiant" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="STUDENTS?action=insert_Etudiant" method="post">
        </c:if>
        <table border="1" cellpadding="5"  class="table table-bordered table-width float-end">
            <caption>
            	<h2>
            		<c:if test="${user != null}">
            			
            		</c:if>
            		<c:if test="${user == null}">
            		
            		</c:if>
            		
            	</h2>
            </caption>
        		<tr>
                <th>CNE: </th>
                <td>
                	<input type="number" name="CNE" size="45"
                			value="<c:out value='${user.CNE}' />"
                		/>
                </td>
            </tr>      
        		 <tr>
                <th>CIN: </th>
                <td>
                	<input type="text" name="CIN" size="45"
                			value="<c:out value='${user.CIN}' />"
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
                <th>Date_of_birthday: </th>
                <td>
                	<input type="text" name="date_de_naissance" size="45"
                			value="<c:out value='${user.date_de_naissance}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>City: </th>
                <td>
                	<input type="text" name="ville" size="45"
                			value="<c:out value='${user.ville}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Street: </th>
                <td>
                	<input type="text" name="rue" size="45"
                			value="<c:out value='${user.rue}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Country: </th>
                <td>
                	<input type="text" name="pay" size="45"
                			value="<c:out value='${user.pay}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Postal_code: </th>
                <td>
                	<input type="number" name="code_postale" size="45"
                			value="<c:out value='${user.code_postale}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${user.email}' />"
                		/>
                </td>
            </tr>
            
            <tr>
                <th>Gender: </th>
                <td>
                	<input type="text" name="sexe" size="45"
                			value="<c:out value='${user.sexe}' />"
                	/>
                </td>
            </tr>
            
             <tr>
                <th>Password: </th>
                <td>
                	<input type="text" name="mot_de_passe" size="45"
                			value="<c:out value='${user.mot_de_passe}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Classe_Name: </th>
                <td>
                	<input type="text" name="nomc" size="45"
                			value="<c:out value='${user.nomc}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Classe_ID: </th>
                <td>
                	<input type="text" name="idc" size="45"
                			value="<c:out value='${user.id}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save"   class="btn btn-primary"/>
            	</td>
            </tr>
        </table>
       
       </form>
    </div>	
</body>
</html>