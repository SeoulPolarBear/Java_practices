<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/result.css"> 
<script type="text/javascript" src="resources/js/back.js"></script>
</head>
<body>


1cm -> ?? inch가 나오는 결과가 나오는 page

길이 : 빨강
넓이 : 초록
온도 : 파랑
속도 : 핑크

		<table border="1">
			<tr>
				<th id = "${r}" colspan="2">변환결과</th>
			</tr>
			<tr>
				<td>숫자</td>
				<td>${origin} ${o} -> ${result} ${r}</td>
			</tr>
			<tr>
				<td colspan="2" ><button onclick="returnto();">돌아가기</button></td>
			</tr>
		</table>
</body>
</html>