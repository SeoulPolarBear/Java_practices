<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	cookies[0].setMaxAge(0);
	response.addCookie(cookies[0]);
	response.sendRedirect("cookie.jsp");
%>

</body>
</html>