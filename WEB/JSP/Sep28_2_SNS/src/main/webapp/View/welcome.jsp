<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����</title>
</head>
<body>

<table id ="loginSuccessTbl">
	<tr>
	<td row ="2"> <img width="50px" height="50px" alt="������" src="View/CSS/img/${sessionScope.loginMember.m_photo }"></td>
	<td>${sessionScope.loginMember.m_id}</td>
	</tr>
	<tr>
	<td colspan ="2">ȯ���մϴ�.</td>
	</tr>
	
	<tr>
	<td align = "center" colspan = "2">
	<button onclick="info();">����</button>
	<button onclick="logout();">�α׾ƿ�</button>
	</td>
	</tr>
</table>

</body>
</html>