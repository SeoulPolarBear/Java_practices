<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Implicit Objects</title>
</head>
<body>
	<p>전송된 요청 파라미터 : 
	<% //getQueryString() 메소드를 이용하여_웹 브라우저 주소의"?"이후의 문자열을 출력합니다.
	out.print(request.getQueryString());
	%>
</body>
</html>