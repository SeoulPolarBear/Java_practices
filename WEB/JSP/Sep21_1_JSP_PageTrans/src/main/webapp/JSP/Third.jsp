<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// Parameter �б�
		int a = Integer.parseInt(request.getParameter("x"));
	
		String b = request.getParameter("y"); // String
		
		// ��ü�� �������Ƿ� �ݵ�� �̷��� �ٲ���Ѵ�.
		String c = String.valueOf(request.getAttribute("c"));
		String d = (String) request.getAttribute("d");
		String e = String.valueOf(request.getAttribute("e"));
	%>
	<h1>Third</h1>
	<h1><%= a %></h1>
	<h1><%= b %></h1>
	<h1><%= c %></h1>
	<h1><%= d %></h1>
	<h1><%= e %></h1>
	
</body>
</html>