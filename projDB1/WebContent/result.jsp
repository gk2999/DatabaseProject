<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<style><%@include file="cssScript.css"%></style>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Using GET and POST Method to Read Form Data</title>
	</head>
	<body>
		<h1>Login Result</h1>
		
			
	
    <ul>
    	
        <% 
    	String un = request.getParameter("username");
        String pw = request.getParameter("password");
    	if (un == "") { 
			out.println("Please enter your name."); }
    	if(pw == ""){
    		out.println("Please enter your password.");
    	}
    	if(un.equals("root")  && pw.equals("pass1234")){
    		out.println("Hello <b>"+"Root user"+"</b>!");
    		
    		%><a href = "rootInterface.jsp">Sign On</a><%
    	}
    	else { 
    		
    		out.println("Hello <b>"+request.getParameter("username")+"</b>!");
		} 
		%>
    </ul>
    
	
	</body>
</html>