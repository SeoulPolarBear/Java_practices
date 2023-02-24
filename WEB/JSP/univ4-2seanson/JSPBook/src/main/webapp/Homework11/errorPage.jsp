<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page errorPage="isErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<%
	String x = "exception";
	if(x=="exception"){
		throw new RuntimeException("");
	}
	%>
</body>
</html>