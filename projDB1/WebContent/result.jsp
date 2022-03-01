<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
    	else { 
			out.println("Hello <b>"+request.getParameter("username")+"</b>!");
		} 
		%>
    </ul>
	
	</body>
</html>