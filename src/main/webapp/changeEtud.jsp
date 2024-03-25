<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<head>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color:white;
      padding: 20px;
       background-size: 50%;
        background-repeat: no-repeat;
      	background-position : 700px 40px; 
		background-position : left;
		 
      background-image: url("https://thumbs.dreamstime.com/b/forgot-password-computer-concept-unhappy-man-near-account-login-flat-vector-male-character-design-landing-page-web-poster-184010038.jpg");
    }
    
 
    
    h2 {
      text-align: center;
      color:#0A2BF9;
    }
    

    
    input[type="password"] {
      width: 100%;
      padding: 10px;
      border-radius: 3px;
    
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
	table{
	width: 30%; height: 30%; position: absolute; top: 30%; left: 60%;
	}
	p{
	top: 50%; left: 60%;}

  </style>
</head>
<body>
 <script>
    function redirectToJSP() {
      window.location.href = "Interface_etudiant.jsp";
    }
  </script> 
<nav>
  <ul >
    <li ><button class="btn btn-primary" onclick="redirectToJSP()">Log out</button></li>
  </ul>
</nav>
  
    <h2><b>Change Password</b></h2>
<form action="modifierEtud?action=modifier_pass" method="post">
    <table border="1" cellpadding="5">
    	<tr>
    		
            <th>Old Password: </th></div>
            <td>
                <input  type="password"  name="pass" required />
            </td>
        </tr>
        <tr>
    		
            <th>New Password: </th>
            <td>
                <input  type="password"  name="new_password" required />
            </td>
        </tr>
        <tr>
    		<th>confirme Password: </th>
            <td>
                <input  type="password"  name="confirme_password" required />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                 
      					<button  class="btn btn-primary">Changer le mot de passe</button>

            </td>
        </tr>
    </table>
    <%-- Afficher le message d'erreur --%>

    <% if (request.getAttribute("errorMessage") != null) { %>
        <b><p style="color: red;position: absolute; top: 60%; left: 60%;font-size: 20px;"><%= request.getAttribute("errorMessage") %></b></p>
    <% } 
    else if  (request.getAttribute("successMessage") != null) { %>
    <b><p style="color: #0A2BF9;position: absolute; top: 60%; left: 60%;font-size: 20px;"><%= request.getAttribute("successMessage") %></b></p>
   
<% } %>
 </form>
 
</body>
</html>