<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���</title>
</head>
<body>
	<form action="LoginController" method="post">
	ID <input name ="id" value ="${cookie.lastLoginId.value}">  <p>
	PW <input type="password" name ="pw"> <img alt="" src="../CSS/rise.png" onclick="" > <p>
	<button>�Է�</button>
	</form>
</body>
</html>