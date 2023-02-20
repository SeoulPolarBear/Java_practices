<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>exception</title>
</head>
<body>
	<p>예외가 발생하였습니다.
	<p>예외 : <%=exception.toString() %>
	<p>toString() : <%=exception.toString() %>
	<p>getClass().getName() : <%=exception.getClass().getName() %>
	<p>getMessage() : <%=exception.getMessage() %>
</body>
</html>