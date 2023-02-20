<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>security</title>
</head>
<body>
<% 
	session.invalidate();
	response.sendRedirect("login.jsp");
%>
	
</body>
</html>