<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Failed</title>
</head>
<body>
	<%
		response.sendRedirect("login.jsp?error=1");//오류 전달을 위해서 요청 파라미터 error를 작성
	%>
</body>
</html>