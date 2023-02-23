<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<p>아이디 : <%= request.getParameter("Name") %>
	<p>주소 : <%= request.getParameter("address") %>
	<p>이메일 : <%= request.getParameter("e_mail") %>
</body>
</html>