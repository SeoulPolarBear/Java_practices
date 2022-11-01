<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���ھ߱�</title>
<!-- Servlet���� �����Ű���� ����η� �ϸ� �ȵȴ�. ���� JS/ValidationOfPlayBall.js �̷��� �����η� �ؾ� �Ѵ�. -->
<script type="text/javascript" src="JS/ValidationOfPlayBall.js"></script>
<script type="text/javascript" src="JS/NumberValidation.js"></script>
<script type="text/javascript" src="JS/PolarbearValidChecker.js"></script>
<link rel="stylesheet" href = "CSS/PlayBall.css">
</head>
<body>

	<form action="HomeController" method = "get" name = "playball" onsubmit="return validation();">
		<table id="play" border = "1">
		<tr><th id = "title" colspan = "3">�߱� ����</th> </tr>
		<tr> 
		<td class = "category">����</td> 
		<td colspan="2"><input id = "input-num" name = "userNum" placeholder="3�ڸ� �ߺ����� �ʴ� ����"></td>
		</tr>
		<tr><th class = "title2" colspan = "3">�Է� ����</th> </tr>
	<c:forEach var="item" items="${userNumList}" varStatus= "status">
		<tr>
		<td class = "category">${status.count}</td>
		<td colspan = "2">${item}</td>
		</tr>
		</c:forEach>
		<tr><th class = "title2" colspan = "3">���</th> </tr>
	<c:forEach var="item2" items="${userResult}" varStatus= "status">
		<tr>
		<td class = "category">${status.count}</td>
		<td colspan = "2">${item2}</td>
		</tr>
		</c:forEach>
		
		<tr>
		<td class = "category">�õ�</td>
		<td colspan = "2">${counter}</td>
		</tr>
		<tr>
		<td class = "category">���</td>
		<td colspan = "2">${result}</td>
		</tr>
		<tr>
		<td colspan = "3"> <button class = "btn">Ȯ��</button> </td>
		</tr>
		</table>
	</form>
</body>
</html>