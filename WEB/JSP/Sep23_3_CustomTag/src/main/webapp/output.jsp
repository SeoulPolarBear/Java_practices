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
<!-- ���ǹ� -->
<c:if test="${ param.n %2 == 0 }">
	¦��
</c:if>
<hr>

<!-- if-else + switch-case ����  -->
<c:choose>
<c:when test="${param.num > 10}">
	10���� ũ��
</c:when>
<c:when test="${param.num > 5}">
	5~10����
</c:when>
<c:otherwise>
	������
</c:otherwise>
</c:choose>


<%
	for(int i = 1; i <=5; i +=2 ){
		System.out.println(i);
	}
%>


<!-- �ݺ��� -->
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
	��� ��� <%= result %>
</c:catch>
<!-- ������ ���� jstl tag���� ����� ������ ���� �ۿ����� ����� �����ϴ�.  -->
<c:catch var="myExcept">
	<%int result = 100 / 0; %>
	��� ��� <%= result %>
</c:catch>
<br>
<c:if test="${myExcept != null}">
 �����߻� : ${myExcept.message }
</c:if>






</body>
</html>