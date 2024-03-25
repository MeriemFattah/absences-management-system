<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
     integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" 
     crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,500;0,600;0,900;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <title>Note Check</title>
</head>
<body>
<style>
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Montserrat', sans-serif;
}
form{
    margin-top: 40px;
    padding: 30px 30px 30px;

    height: 220px;
}
.navbar{
    display: flex;
    justify-content: space-evenly;
    margin-top: 25px;
}
.student{
    width: 100%;
    min-height: 50vh;
    display: flex;
    justify-content: center;
    
}
.authentication{
    margin-top: 30px;
}
.logo{
    height: 80px;
    width: 150px;
}
h2{
    color: rgb(68, 80, 97);
    width: 500px;
    padding: 14px 10px;
    font-family: 900;
    font-size: 30px;
    text-align: center;
    margin-left: 420px;
    margin-top: 60px;
}
label{
    font-size: 20px;
}

#module{
    margin-left: 80px;
    height: 40px;
    width: 250px;
    outline: none;
    text-align: center;
    border-radius: 5px;
}

.submit{
    margin-top: 50px;
    height: 60px;
    width: 150px;
    margin-left: 150px;
    color: whitesmoke;
    font-family: 25px;
    background-color: rgb(68, 80, 97);
    border-radius: 15px;
    font-size: 16px;
    border: none;
}
.submit:hover{
    background-color: rgb(118, 131, 150);
    cursor: pointer;
}
</style>
    <div class="content">
        
        <div class="navbar">
            <img class="logo" src="ensalogo.png" alt="">
        </div>
        <h2>Attendance :</h2>
        <div class="student">
          <form method="post" action="AbsenceServlet">
              <div class="authentication">
                  <div class="id">
                      <label class="label1" for="module" >Course</label>
                      <input type="text" name="module" placeholder="Enter Course" id="module">
                  </div>
              </div>
              <input class="submit" type="submit" value="Search" >
          </form>
      </div>
        <table class="table table-striped container mt-5">
            <thead class="table-dark">
            
              <tr>
                <th scope="col">ETAT</th>
                <th scope="col">JUSTIFICATION</th>
                <th scope="col">DATE Of Attendance</th>

              </tr>
            </thead>
            <tbody>
            <c:forEach var="absence" items="${absences}">
              <tr>
                <td>${absence.etat}</ </td>
                <td>${absence.just}</</td>
                <td>${absence.date}</</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
    </div>
    
</body>
</html>