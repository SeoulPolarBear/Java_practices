<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Implicit Tag</title>
</head>
<body>
	<%
	response.setIntHeader("Refresh", 5);
	out.println("오늘의 날짜 및 시각" + "<br>" + java.util.Calendar.getInstance().getTime());
	%>
</body>
</html>