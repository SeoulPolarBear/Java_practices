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
	request.setAttribute("RequestAttribute", "request ���尴ü");
	%>
	${requestScope.RequestAttribute }
</body>
</html>