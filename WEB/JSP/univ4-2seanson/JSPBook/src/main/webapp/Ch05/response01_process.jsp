<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Implicit Tag</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("id");
	String password = request.getParameter("pass");
	
	if(userid.equals("관리자")&&password.equals("1234")){
		response.sendRedirect("response01_success.jsp");
	}
	else{
		response.sendRedirect("response01_failed.jsp");
	}
%>
	
</body>
</html>