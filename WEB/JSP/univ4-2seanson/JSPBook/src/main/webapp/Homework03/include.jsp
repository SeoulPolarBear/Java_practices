<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Directive Tag</title>
</head>
<body>
<%@ page import = "java.util.Date" %>
	<%@ include file="header.jsp" %>
	현재 시간 : <%= new Date() %>
</body>
</html>