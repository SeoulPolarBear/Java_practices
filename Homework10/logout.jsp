<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Security</title>
</head>
<body>
<% 
	session.invalidate();
	response.sendRedirect("security.jsp");
%>
</body>
</html>