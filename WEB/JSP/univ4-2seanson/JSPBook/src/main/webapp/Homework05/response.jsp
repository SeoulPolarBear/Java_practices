<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Implicit Objects</title>
</head>
<body>
	<p> 현재시간은 <%=java.util.Calendar.getInstance().getTime()%>
	<% response.setIntHeader("Refresh", 5);%>
	<br>
	<a href = " response_data.jsp">Google 홈페이지로 이동하기</a>
</body>
</html>