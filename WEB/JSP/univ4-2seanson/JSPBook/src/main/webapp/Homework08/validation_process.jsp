<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation_process</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	%>
	
	<p> 아이디 : <%=id%>
	<p> 비밀번호 : <%=passwd%>
</body>
</html>