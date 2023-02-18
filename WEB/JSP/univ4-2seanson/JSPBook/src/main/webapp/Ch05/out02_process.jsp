<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>implicit Tag</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");
String userid = request.getParameter("id");
String password = request.getParameter("passwd");
%>
<p>아이디 :<%out.println(userid); %>
<p>아이디 :<%out.println(password); %>
</body>
</html>