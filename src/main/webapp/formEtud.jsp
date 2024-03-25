<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student's Information</title>
    <style>
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin: 0 auto;
            max-width: 800px;
            padding: 20px;
        }
        .input-wrapper {
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
            margin-right: 40px;
            width: calc(50% - 40px);
        }
        .input-wrapper:last-child {
            margin-right: 0;
        }
        .input-wrapper label {
            font-weight: bold;
        }
        .input-wrapper input {
            background-color: #e3e1fe;
            border: none;
            margin-top: 5px;
            padding: 10px;
            width: 100%;
        }
    </style>
</head>
<body>
	 <h1><center>Student's Information</center></h1>
    <div class="container">
        <form action="search" method="Get">
        </form>
        <div class="input-wrapper">
            <label>CNE:</label>
            <input id="cne" type="number" name="CIN" value="${user.cne}" readonly>
        </div>
        <div class="input-wrapper">
            <label>Last Name:</label>
            <input type="text" id="nom" name="nom" value="${user.nom}" readonly>
        </div>
        <div class="input-wrapper">
            <label>First Name:</label>
            <input type="text" name="prenom" value="${user.prenom}" readonly>
        </div>
        <div class="input-wrapper">
            <label>Gender :</label>
            <input type="text" name="date_de_naissance" value="${user.sexe}" readonly>
        </div>
        <div class="input-wrapper">
            <label>Date of Birth:</label>
            <input type="text" name="ville" value="${user.date}" readonly>
        </div>
        <div class="input-wrapper">
            <label>Phone 'Number:</label>
            <input type="text" name="tel" value="${user.num}" readonly>
        </div>
        <div class="input-wrapper">
            <label>Country:</label>
            <input type="text" name="pay" value="${user.pay}" readonly>
        </div>
        <div class="input-wrapper">
            <label>City:</label>
            <input type="text" name="sexe" value="${user.ville}" readonly>
        </div>
        <div class="input-wrapper">
            <label>Email:</label>
            <input type="text" name="email" value="${user.email}" readonly>
        </div>
    </div>
</body>
</html>
