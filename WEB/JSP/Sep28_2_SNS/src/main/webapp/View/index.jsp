<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="View/CSS/index.css">
<link rel="stylesheet" href="View/CSS/signUp.css">
<script type="text/javascript" src ="View/JS/go.js"></script>
</head>
<body>
	<div id="total">
		<div id="siteBar">
			<table>
				<tr id="siteTitle">
					<td><a href="" class="site">SNS Mode</a></td>
				</tr>
				<tr>
					<td id="siteMenu"><a class="site" href="">Board</a></td>
				</tr>
			</table>
		</div>

		<div id="login">
			<jsp:include page="${loginPage}" />
		</div>

		<div id="content">
			<table>
				<tr>
					<td align="center"><jsp:include page="${contentPage}"/></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>