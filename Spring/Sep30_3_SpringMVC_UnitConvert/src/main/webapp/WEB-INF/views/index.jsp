<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="trans.do" method="get">
		<table border="1">
			<tr>
				<th colspan="2">입력</th>
			</tr>
			<tr>
				<td>숫자</td>
				<td><input type="text" name="num"></td>
			</tr>
			<tr>
				<td>옵션</td>
				<td><select name="change">
						<option value="inch">cm -> inch</option>
						<option value="area">m^2 -> area</option>
						<option value="F">C -> F</option>
						<option value="km_per_h">mi/h -> km/h</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><button>변환</button></td>
			</tr>
		</table>
	</form>
</body>
</html>