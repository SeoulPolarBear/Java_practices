<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Directive Tag</title>
</head>
<body>
	<%
	request.setAttribute("RequestAttribute", "request 내장객체");
	%>
	${requestScope.RequestAttribute }
</body>
</html>