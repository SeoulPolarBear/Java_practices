<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Security</title>
</head>
<body>
	<form name = "loginForm" action="j_security_check" method = "post">
	<p> 사용자명: <input type = "text" name = "j_username">
	<p> 사용자명: <input type = "password" name = "j_password">
	<p><input type = "submit" value = "전송">
	</form>
</body>
</html>