<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Security</title>
</head>
<body>
	<% if(request.isUserInRole("admin")){
		response.sendRedirect("success.jsp");	
	}	
	%>
</body>
</html>