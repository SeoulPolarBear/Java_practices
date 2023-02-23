<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Security</title>
</head>
<body>
	<p>사용자명<%=request.getRemoteUser() %>인증을 성공했습니다.
	<p><a href = "logout">logout</a>
</body>
</html>