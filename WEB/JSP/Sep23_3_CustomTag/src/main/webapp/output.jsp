<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>${param.num}</h1>
<!-- 조건문 -->
<c:if test="${ param.n %2 == 0 }">
	짝수
</c:if>
<hr>

<!-- if-else + switch-case 느낌  -->
<c:choose>
<c:when test="${param.num > 10}">
	10보다 크다
</c:when>
<c:when test="${param.num > 5}">
	5~10사이
</c:when>
<c:otherwise>
	나머지
</c:otherwise>
</c:choose>


<%
	for(int i = 1; i <=5; i +=2 ){
		System.out.println(i);
	}
%>


<!-- 반복문 -->
<c:forEach var="v" items="${ar}" begin="1" end="${param.num}" step="1" varStatus="status">
	<marquee>${status.count} ${v}</marquee>
</c:forEach>

<%
/* for(String str: ar){
	System.out.println(str);
} */
%>

<c:forEach var="i" items="${ar}" >
	<marquee>${v}</marquee>
</c:forEach>

<c:forEach var="j" items="${al}" >
	<marquee>${j.name} - ${j.age}</marquee>
</c:forEach>


<!-- try-catch -->

<c:catch var="myExcept">
	<%int result = 100 / 2; %>
	계산 결과 <%= result %>
</c:catch>
<!-- 다음과 같이 jstl tag에서 사용한 값들은 전부 밖에서도 사용이 가능하다.  -->
<c:catch var="myExcept">
	<%int result = 100 / 0; %>
	계산 결과 <%= result %>
</c:catch>
<br>
<c:if test="${myExcept != null}">
 에러발생 : ${myExcept.message }
</c:if>






</body>
</html>