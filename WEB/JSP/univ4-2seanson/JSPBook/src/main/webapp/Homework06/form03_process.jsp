<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String[] fruit = request.getParameterValues("fruit");
	%>
	<p>선택한 과일
	<p><% if (fruit != null){
		for(int i = 0; i < fruit.length; i++){
			out.println(" " + fruit[i]);
		}
	}
	%>
</body>
</html>