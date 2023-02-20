<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<p>오류가 발생했습니다.
	<p>예외 유형 : <%=exception.getClass().getName() %>
	<p> 오류 메세지 : <%=exception.getMessage() %>
</body>
</html>