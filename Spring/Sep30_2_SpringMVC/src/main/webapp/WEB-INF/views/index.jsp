<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/index.js"></script>

</head>
<body>
	View (V) -
		JSP : .html or .jsp
		Spring : .jsp (봄)
		Spring Boot : .html (늦봄)
		
		Spring 내에서 쓰는 자원파일들(css, js, 그림, ...)
			webapp - resources /...(경로)에서 사용
			
		<hr>
		
		input 3개 -> 이름, x,y
		button 하나를
		form에 담기
		
	<form action="calculate.do" method="post">
	이름 : <input type="text" name = "n"> <br>
	x : <input type="text" name = "x"> <br>
	y : <input type="text" name = "y"> <br>
	<button>버튼</button>
	</form>
	
<hr>

<c:if test="${r != null }">계산 결과 : ${r }</c:if>
	
	
	
	
</body>
</html>