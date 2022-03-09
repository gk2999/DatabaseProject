<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<style><%@include file="cssScript.css"%></style>
	</head>
	<body>
		<h1>User Login</h1>
		<form action="userLogin" method="GET">
		
        Username: <input type="text" placeholder="Enter Username" name="email"> <br>
        Password: <input type="password" placeholder="Enter Password" name="pw" /><br>
        <h3 style = "color: red"> ${InvalidUN}</h3><br>
        	<button type="submit">Login</button>
         <br>
         <a href="signup.jsp"> No Account? Sign up here </a>
    	</form>
    </body>
</html>