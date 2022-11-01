<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>enroll</title>
<script type="text/javascript" src="PolarbearValidChecker.js"></script>
<script type="text/javascript" src="Validation.js"></script>
</head>
<body>
	<!-- 색 맛 select-option + 유효성 검사 POST 방식 -->
	<form action="enrollController" method="post" name="f" onsubmit = "return validation();">
	<table>
	<tr>
		<th>부위</th>
				<td><select name ="m_kind">
				<optgroup label="cow">
				<option value ="RIB">RIB</option>
				<option value ="LOIN">LOIN</option>
				<option value ="CHUCK">CHUCK</option>
					<option value ="BRISKET">BRISKET</option>
					<option value ="PLATE">PLATE</option>
					<option value ="FLANK">FLANK</option>
					<option value ="SHANK">SHANK</option>
				</optgroup>
				
				<optgroup label="pig">
				<option value ="HAM">HAM</option>
				<option value ="LOIN">LOIN</option>
				<option value ="SHOULDER">SHOULDER</option>
				<option value ="LEG">LEG</option>
				</optgroup>
				
				<optgroup label="rabbit">
				<option value ="LOIN">LOIN</option>
				<option value ="RIB">RIB</option>
				<option value ="SHOULDER">SHOULDER</option>
				<option value ="RACK">RACK</option>
				<option value ="LEG">LEG</option>
				</optgroup>
				
				<optgroup label="chicken">
				<option value ="BREAST">BREAST</option>
				<option value ="WING">WING</option>
				<option value ="THIGH">THIGH</option>
				</optgroup>
				
				<optgroup label="sheep">
				<option value ="LOIN">LOIN</option>
				<option value ="BREAST">BREAST</option>
				<option value ="SHOULDER">SHOULDER</option>
				<option value ="RACK">RACK</option>
				<option value ="LEG">LEG</option>
				</optgroup>
			</select></td>
		</tr>
		<tr>
			<th>동물:</th>
			<td><select name ="m_from">
					<option value ="pig">pig</option>
					<option value ="cow">cow</option>
					<option value ="rabbit">rabbit</option>
					<option value ="sheep">sheep</option>
					<option value ="chicken">chicken</option>
			</select></td>
		</tr>
		<tr>
		<th>가격</th>
			<td><input type="text" name="m_price"></td>
		</tr>
		<tr>
		<th>설명</th>
		<td> <textarea rows="20px" cols="20px" name="m_introduce"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"> <button>insert</button> </td>
		</tr>

	</table>
	
</form>
</body>
</html>