<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="index.js"></script>
</head>
<body>
	<!-- 회원가입 
	id/ pw확인 / 이름 /우편번호, 주소(input 3개로 나눠서), 상세주소 / 버튼 -->

	<table border = "1">
		<tr>
			<td>id : </td><td><input type="text" name="ID"></td>
		</tr>
		<tr>
			<td>PW : </td><td><input type="password" name="Passwd"></td> 
		</tr>
		<tr>
			<td>PW 확인: </td><td><input type="password" name="Passwdchk"></td> 
		</tr>
		<tr>
			<td>address : </td><td><input id="addr1" readonly="readonly"><br>
			- <input id="addr2" readonly="readonly"> <br>
			- <input id="addr3" placeholder="상세주소"></td>
		</tr>
		<tr>
			<td colspan = "2"><button>제출</button> </td> 
		</tr>
	</table>
</body>
</html>