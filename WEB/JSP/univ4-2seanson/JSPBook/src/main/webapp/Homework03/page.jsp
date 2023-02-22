<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Directives Tag</title>
</head>
<body>
<%@ page import ="java.util.Date,java.lang.Math" %>
	현재 날짜 : <%=new Date()%><br>
	5의 제곱 : <%=Math.pow(5, 2)%> 
</body>
</html>