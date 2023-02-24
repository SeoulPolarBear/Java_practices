<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>

	<h3>오류발생</h3>
	<table border="1">
	<tr><th width = "100px">Error:</th>
	<td width = "400px"><%=exception.getClass().getName() %>: 오류발생!!!</td>
	
	<tr><th width = "100px">URL:</th>
	<td width = "400px"><%=request.getRequestURL() %></td>
	
	<tr><th width = "100px">Status code: </th>
	<td width = "400px"><%= request.getAttribute("javax.servlet.error.status_code") %></td>
	</table>
</body>
</html>