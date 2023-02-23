<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.util.*, java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Enumeration paraNames = request.getParameterNames();
	while (paraNames.hasMoreElements()){
		String Name = (String) paraNames.nextElement();
		out.print(Name + " : ");
		String pramValue = request.getParameter(Name);
		out.print(pramValue + "<br>");
	}
	%>
	 
</body>
</html>