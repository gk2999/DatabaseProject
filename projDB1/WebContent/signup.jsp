<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link href="cssScript.css" rel="stylesheet" type="text/css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<form action="insert" method="get">

	<h1>Create an Account</h1>
	email: <input type="text" name="username"><br>
	password: <input type="text" name="password"><br> 
	re-confirm password: <input type="text" name="password"><br>
	first name: <input type="text" name="fN"><br>
	last name: <input type="text" name="lN"><br>
	age: <input type="text" name="age"><br>
	<a href="login.jsp"> Go Back </a>&emsp;
	<input type="submit" value="Sign Up" />

</form>
	
</body>
</html>