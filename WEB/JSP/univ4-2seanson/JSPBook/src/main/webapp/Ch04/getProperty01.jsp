<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Tag</title>
</head>
<body>
	<jsp:useBean id = "person" class="ch04.com.dao.Person" scope="request"	/>
	<p>���̵� : <jsp:getProperty name="person" property="id"	/>
	<p>�� �� : <jsp:getProperty name="person" property="name"	/>
</body>
</html>