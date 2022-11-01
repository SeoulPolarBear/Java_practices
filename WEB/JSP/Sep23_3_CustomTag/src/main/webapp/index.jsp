<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>bar</title>
<link rel="stylesheet" href="./CSS/INDEX.css">
</head>
<body>
	<table id="Total">
		<tr>
			<th id="siteTitle">2022년 9월 23일</th>
		</tr>
		<tr>
			<td id="siteMenu">
			<a href="HomeController">Home</a> 
			<a href="NumController">a</a> 
			<a href="JSTLController">b</a> 
			<a href="JSTLFController">c</a>
		</td>
		</tr>
		<tr>
		<td id="siteContent"><jsp:include page="${contentPage }"></jsp:include>
		</td>
		</tr>
	</table>
</body>
</html>