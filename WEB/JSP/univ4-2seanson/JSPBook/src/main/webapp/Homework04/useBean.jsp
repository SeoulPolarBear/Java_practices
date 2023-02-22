<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Tag</title>
</head>
<body>
	<h4>구구단 출력하기</h4>
	<jsp:useBean id="gugu" class="ch04.com.dao.GuGuDan" />
	<% int fiveDan[] = gugu.process(5);
	for(int i = 0; i<9 ;i++){
		out.println(5 + "*" + (i+1) + "=" + fiveDan[i] + "<br>");
	}
	%>
</body>
</html>