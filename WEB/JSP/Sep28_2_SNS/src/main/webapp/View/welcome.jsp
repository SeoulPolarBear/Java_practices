<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>성공</title>
</head>
<body>

<table id ="loginSuccessTbl">
	<tr>
	<td row ="2"> <img width="50px" height="50px" alt="프로필" src="View/CSS/img/${sessionScope.loginMember.m_photo }"></td>
	<td>${sessionScope.loginMember.m_id}</td>
	</tr>
	<tr>
	<td colspan ="2">환영합니다.</td>
	</tr>
	
	<tr>
	<td align = "center" colspan = "2">
	<button onclick="info();">정보</button>
	<button onclick="logout();">로그아웃</button>
	</td>
	</tr>
</table>

</body>
</html>