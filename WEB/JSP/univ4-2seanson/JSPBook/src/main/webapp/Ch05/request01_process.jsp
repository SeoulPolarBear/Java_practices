<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Implicit Objects</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<p>아이디 : <%=request.getParameter("id") %>
	<p>비밀번호 : <%=request.getParameter("passwd") %>
</body>
</html>