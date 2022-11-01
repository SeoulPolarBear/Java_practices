<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>숫자야구</title>
<!-- Servlet에서 실행시키려면 상대경로로 하면 안된다. 따라서 JS/ValidationOfPlayBall.js 이렇게 절대경로로 해야 한다. -->
<script type="text/javascript" src="JS/ValidationOfPlayBall.js"></script>
<script type="text/javascript" src="JS/NumberValidation.js"></script>
<script type="text/javascript" src="JS/PolarbearValidChecker.js"></script>
<link rel="stylesheet" href = "CSS/PlayBall.css">
</head>
<body>

	<form action="HomeController" method = "get" name = "playball" onsubmit="return validation();">
		<table id="play" border = "1">
		<tr><th id = "title" colspan = "3">야구 게임</th> </tr>
		<tr> 
		<td class = "category">숫자</td> 
		<td colspan="2"><input id = "input-num" name = "userNum" placeholder="3자리 중복되지 않는 숫자"></td>
		</tr>
		<tr><th class = "title2" colspan = "3">입력 숫자</th> </tr>
	<c:forEach var="item" items="${userNumList}" varStatus= "status">
		<tr>
		<td class = "category">${status.count}</td>
		<td colspan = "2">${item}</td>
		</tr>
		</c:forEach>
		<tr><th class = "title2" colspan = "3">결과</th> </tr>
	<c:forEach var="item2" items="${userResult}" varStatus= "status">
		<tr>
		<td class = "category">${status.count}</td>
		<td colspan = "2">${item2}</td>
		</tr>
		</c:forEach>
		
		<tr>
		<td class = "category">시도</td>
		<td colspan = "2">${counter}</td>
		</tr>
		<tr>
		<td class = "category">결과</td>
		<td colspan = "2">${result}</td>
		</tr>
		<tr>
		<td colspan = "3"> <button class = "btn">확인</button> </td>
		</tr>
		</table>
	</form>
</body>
</html>