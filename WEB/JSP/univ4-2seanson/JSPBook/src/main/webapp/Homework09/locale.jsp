<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "java.util.Locale" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Internationalization</title>
</head>
<body>
	<% 
		//Locale locale = request.getLocale();
	Locale locale = new Locale("ko", "KR");
	%>
	<h3>현재 로케일</h3>
	<p><br>
	<p>언어 : <%= locale.getLanguage() %>
	<p>국가 : <%= locale.getCountry() %>
</body>
</html>