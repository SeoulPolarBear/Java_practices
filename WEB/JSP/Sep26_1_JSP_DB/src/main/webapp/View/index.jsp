<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>main page</title>
<link rel = "stylesheet" href="CSS/index.css">
<script type="text/javascript" src="JS/go.js"></script>
</head>
<body>
	
	<table id = "main-content">
	<tr>
	<th id = "title-bar">
	<a id = "title" href="HomeController">home</a>
	</th>
	</tr>
	<tr>
	<td>
	<jsp:include page="${contentPage}"></jsp:include>
	</td>
	</tr>
	</table>

	<table id = "menu-bar">
	<tr>
	<td class = "mini"><a class = "mini-bar" href="MeatPageController">meat</a></td>
	<td class = "mini"><a class = "mini-bar" href="">메뉴2</a></td>
	<td class = "mini"><a class = "mini-bar" href="">메뉴3</a></td>
	<td class = "mini"><a class = "mini-bar" href="DBCController">DB연결</a></td>
	</tr>
	</table>
</body>
</html>