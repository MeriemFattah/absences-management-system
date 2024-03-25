<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Administration</title>
        <meta charset='utf-8'>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
 nav{
 background-color: #EAF2F8  ;}
    
 ul {
    list-style-type: none;
    left: 150px;
  }

  nav li {
    display: inline-block;
    margin-right: 10px;
  }

  nav a {
    display: block;
    padding: 10px;
    text-decoration: none;
    color:#7192F7 ;
    font-size: 20px;
  }
  nav a:hover {
 
  background-color: #0069d9;
  color: #fff;
}
  body {
        background-image: url("https://img.freepik.com/vecteurs-libre/gens-qui-etudient-distance-e-learning-enseignement-domicile-enseignement-distance-college-ligne_335657-3297.jpg?w=740&t=st=1683637136~exp=1683637736~hmac=50fd736cf5b737c554c2ee567990899d5bf6ea42175bfd277bd11c85973d4821");
        background-size: 50%;
         background-repeat: no-repeat;
      	background-position : 700px 40px; 
		background-position : right buttom;
		 
      }
   h2 {
    margin-left:80px;
    margin-top: 150px;
    font-family:Arial, sans-serif;
    
    font-size: 30px;
  }
  p{
  	 margin-left:130px;
  	 font-size: 25px;
  }
  button {
  background-color: #007bff;
  border: none;
  color: #fff;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius: 50px;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.25);
  margin-left:350px;
   margin-top:10px;
}
button:hover {
 
  background-color: #0069d9;
  color: #fff;
}

button:active {
 
  background-color: #005cbf;
  color: #fff;
  box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.25);
}
#paragraphe-2 {
	 margin-left:220px;
  	 font-size: 25px;
  	 margin-top:80px;
}
</style>
<body>
<nav>
  <ul >
    <li><b><a href="Etudiant_Space"> YOUR INFO</a></b></li>
    <li><b><a href="NoteServlet" > YOUR GRADES</a></b></li>
    <li><b><a href="AbsenceServlet"> YOUR SANCTIONS</a></b></li>
  </ul>
</nav>
<h2><b>WELCOME TO YOUR SPACE STUDENT </b></h2>
<p>!!!KEEP UP THE GOOD WORK ,STUDENT!!!</p> 
<p id="paragraphe-2">TO CHANGE YOUR PASSWORD</p>       
 <script>
    function redirectToJSP() {
      window.location.href = "changeEtud.jsp";
    }
  </script>      
<button onclick="redirectToJSP()">click here</button>

</body>
</html>