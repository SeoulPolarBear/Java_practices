<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<!-- 
	MyBatis 활용
	전체 과일데이터를 가격순으로
	이름 - 가격 형태로 출력
	(ex: 귤 - \ 2,800)
 -->
 <table border = "1">
 	<c:forEach var ="fruit" items="${fruits}">
 	<tr>
 		<td>${fruit.f_name} - 
 		<fmt:formatNumber 
 		value="${fruit.f_price}"
 		 currencySymbol="\\" type="currency" />
 		</td>
 	</tr>
 	</c:forEach>
 	
 </table>


</body>
</html>