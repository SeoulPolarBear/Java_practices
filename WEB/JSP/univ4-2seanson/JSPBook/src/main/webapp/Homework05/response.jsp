<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Implicit Objects</title>
</head>
<body>
	<p> ����ð��� <%=java.util.Calendar.getInstance().getTime()%>
	<% response.setIntHeader("Refresh", 5);%>
	<br>
	<a href = " response_data.jsp">Google Ȩ�������� �̵��ϱ�</a>
</body>
</html>