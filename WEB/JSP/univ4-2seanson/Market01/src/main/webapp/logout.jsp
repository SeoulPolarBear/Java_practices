<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>logoute</title>
</head>
<body>
	<%
		session.invalidate();
		response.sendRedirect("addProduct.jsp");
	%>
</body>
</html>