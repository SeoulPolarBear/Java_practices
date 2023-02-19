<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.io.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Form Tag</title>
</head>
<body>
	<table border="1">
	<tr>
	<th>요청 파라미터 이름</th>
	<th>오청 파라미터 값</th>
	</tr>
	<% request.setCharacterEncoding("utf-8");
	
	Enumeration paramNames = request.getParameterNames();
	while(paramNames.hasMoreElements()){
		String name = (String) paramNames.nextElement();
		out.println("<tr><td>" + name +"</td>\n");
		String paramValue = request.getParameter(name);
		out.println("<td>" + paramValue +"</td></tr>\n");
	}
	%>
	</table>
</body>
</html>