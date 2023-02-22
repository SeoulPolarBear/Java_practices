<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import ="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Scripting Tag</title>
</head>
<body>
Current Time : <%= java.util.Calendar.getInstance().getTime() %>
<%

Calendar cal =new Calendar().getInstance().getTime();

int hour = cal.getHour();
%>

</body>
</html>