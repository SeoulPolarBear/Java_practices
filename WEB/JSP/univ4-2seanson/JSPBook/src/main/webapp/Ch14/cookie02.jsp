<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Cookie</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	out.println("현재 설정된 쿠키의 개수 => " + cookies.length + "<br>");
	out.println("================================<br>");
	for(int i = 0; i <cookies.length; i++){
		out.println("설정된 쿠키의 속성 이름 [" + " ] : " + cookies[i].getName() + "<br>");
		out.println("설정된 쿠키의 속성 값 [" + " ] : " + cookies[i].getValue() + "<br>");
		out.println("----------------------------------------<br>");
	}
%>
</body>
</html>