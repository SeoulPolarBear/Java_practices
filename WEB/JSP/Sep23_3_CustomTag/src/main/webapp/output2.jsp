<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <!-- core가 있어야 fmt를 쓸 수 있다. (x) -->
    <!-- core / fmt 자주 쓰는 기능이라 보통은 둘 다 가져다 씀 -->
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>fmt</title>
</head>
<body>
<!-- fmt: 문자열 / 날짜 형태 포맷팅 -->


<!-- 숫자관련 format -->
<fmt:formatNumber value = "${a }" type="number"/><p>
<!-- 123,456,789 -->

<!-- 통화관련 format -->
<fmt:formatNumber value = "${a }" type="currency" currencySymbol="$"/><p>
<!-- $123,456,789 -->

<!-- 숫자관련 format (소수점은 반올림 해준다.)-->
<fmt:formatNumber value = "${b }" type="percent"/><p>

<fmt:formatNumber value = "${c }" pattern="#.00"/><p>

<hr>

<!-- Date 속성
		: type = "date / time / both"
		1. date 
			dateStyle = "short / long"
		2. time
			timeStyle "short / long"
		3. both
			dateStyle = "short / long"
			timeStyle "short / long"
 -->

<fmt:formatDate value="${d}" type ="both" dateStyle="long" timeStyle="short"/> <br>

<!-- 패턴 -->

<fmt:formatDate value="${d}"  pattern="yyyy-MM-dd E a hh"/><br>














</body>
</html>