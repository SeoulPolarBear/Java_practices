<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Action Tag</title>
</head>
<body>
	<p>아이디 : <%= request.getParameter("id") %>
	<%
	String name = request.getParameter("name");
	%>
	<p>이 름 : <%=java.net.URLDecoder.decode(name) %>
</body>
</html>