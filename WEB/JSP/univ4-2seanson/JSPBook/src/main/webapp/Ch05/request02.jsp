<%@page import = "java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Implicit Tag</title>
</head>
<body>
	<%
	Enumeration en = request.getHeaderNames();
	while(en.hasMoreElements()){
		String headerName = (String) en.nextElement();
		String headerValue = request.getHeader(headerName);
	
	%>
	<%=headerName %>:<%=headerValue%><br>
	<%
	}
	%>
</body>
</html>