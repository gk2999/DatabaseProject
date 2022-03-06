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
		<form action="result.jsp" method="GET">
        Username: <input type="text" placeholder="Enter Username" name="username"> <br>
        Password: <input type="password" placeholder="Enter Password" name="password" /> 
        	<button type="submit">Login</button>
         <br>
         <a href="signup.jsp"> No Account? Sign up here </a>
    	</form>
    </body>
</html>