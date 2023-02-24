<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page errorPage = "exception_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<%
	String Id = request.getParameter("Id");
	String Passwd = request.getParameter("Passwd");
	
	if(Id.equals("")||Passwd.equals("")){
		throw new ServletException("");
	}else
	{
	%>
	<p>아이디 : <%= Id%>
	<p>아이디 : <%= Passwd%>
	
	<%
	}
	%>
</body>
</html>