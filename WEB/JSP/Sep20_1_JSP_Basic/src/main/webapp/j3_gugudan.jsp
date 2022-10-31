<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>구구단</title>
<link rel="stylesheet" href="./CSS/gugudan.css">
<style type="text/css">
table {
	float: left;
}
</style>

</head>
<body>
	<%
	for (int i = 2; i < 10; i++) {
	%>
	<table border="1" class="main2">
		<tr>
			<th class="dan"><%=i%>단</th>
		</tr>
		<tr>
			<%
			for (int j = 2; j < 10; j++) {
			%>
			<td class="gugu"><%=j%> X <%=i%> = <%=j * i%></td>

		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>
	<table border="1" id="main">
		<tr>
			<%
			for (int i = 2; i < 10; i++) {
			%>
			<th class="dan"><%=i%>단</th>
			<%
			}
			%>
		</tr>
		<%
		for (int i = 1; i < 10; i++) {
		%>
		<tr>
			<%
			for (int j = 2; j < 10; j++) {
			%>
			<td class="gugu"><%=j%> X <%=i%> = <%=j * i%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>