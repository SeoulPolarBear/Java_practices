<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<form action="SignUpController" method="post" enctype="multipart/form-data" name="signupForm">
	<table id = "signup-table">
		<tr>
			<th>ID</th>
			<td><input type="text" name="m_id"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name="m_passwd"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="m_name"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><select name="m_phoneNum1">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="080">080</option>
					<option value="02">02</option>
					<option value="051">051</option>
					<option value="053">053</option>
					<option value="032">032</option>
					<option value="062">062</option>
					<option value="042">042</option>
					<option value="052">052</option>
					<option value="044">044</option>
					<option value="031">031</option>
					<option value="043">043</option>
					<option value="041">041</option>
					<option value="063">063</option>
					<option value="061">061</option>
					<option value="054">054</option>
					<option value="055">055</option>
					<option value="064">064</option>
			</select> - <input type="text" name="m_phoneNum2"> - <input
				type="text" name="m_phoneNum3"></td>
		</tr>
		<tr>
			<th>생일</th>
			<td><select name="m_y">
			<c:forEach var ="y" begin="${curYear - 100}" end="${curYear}">
					<option value="${y}">${y}</option>
					</c:forEach>
			</select> - <select name="m_m">
			<c:forEach var ="m" begin="1" end="12">
					<option value="${m}">${m}</option>
		</c:forEach>
			</select> - <select name="m_d">
			<c:forEach var ="d" begin="1" end="31">
					<option value="${d}">${d}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<th>사진</th>
			<td><input type="file" name="m_photo"></td>
		</tr>
		
		<tr>
			<td colspan="2"><button>제출</button> </td>
		</tr>

	</table>
	</form>
</body>
</html>