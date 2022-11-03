<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>thirdV</title>
</head>
<body>
<h1>Third</h1>
<hr>
a:${param.a} <br>
b:${param.b} <br>
c:${cc} <br>
d : ${sessionScope.d }<br>
<%
	//실행했을 때 무한루프 : include가 잘못 됐을 때
	//						 	or 없는 페이지를 include했을 때
%>
<hr>
<jsp:include page="${baby}"/>

</body>
</html>