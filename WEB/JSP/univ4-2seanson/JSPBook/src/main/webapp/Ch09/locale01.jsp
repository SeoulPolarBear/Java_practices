<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "java.text.NumberFormat" %>
<%@ page import = "java.text.DateFormat" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Internationalization</title>
</head>
<body>
	<h3>현재 로케일의 국가, 날짜, 통화</h3>
	<%
	Locale locale = request.getLocale();
	Date currentDate = new Date();
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL,locale);
	NumberFormat numberformat = NumberFormat.getNumberInstance(locale);
	%>
	<p> 국가 : <%= locale.getDisplayCountry() %>
	<p> 날짜 : <%= dateFormat.format(currentDate) %>
	<p> 숫자 : <%= numberformat.format(12345.67) %>
</body>
</html>