<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<%
	try{
		int i = 1;
		int j = 0;
		out.print(i/j);
	}catch(Exception e){
	%>
	<p>오류 발생: <%=e.getLocalizedMessage()%>
	<%
	}
	%>
</body>
</html>