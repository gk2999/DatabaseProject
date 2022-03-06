<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<style><%@include file="cssScript.css"%></style>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<form action="insert" method="get">

	<h1>Create an Account</h1>
	Email: <input type="text" placeholder="Enter Email Address" name="email"><br>
	Password: <input type="text" placeholder="Enter Password" name="pw"><br> 
	Re-Confirm Password: <input type="text" placeholder="Confirm Password" name="pw"><br>
	First Name: <input type="text" placeholder="Enter First Name" name="fN"><br>
	Last Name: <input type="text" placeholder="Enter Last Name" name="lN"><br>
	Age: <input type="text" placeholder="Enter Age" name="age"><br>
	<button type="submit" value="Sign Up">Sign Up</button>
	<a href="login.jsp"> Go Back </a>&emsp;

</form>
	
</body>
</html>