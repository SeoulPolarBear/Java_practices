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
	String userID = (String)session.getAttribute("userID");
if(userID==null){
	response.sendRedirect("session_out.jsp");
		}
	out.println(userID + "님 반갑습니다");
%>
<p><a href = "session_out.jsp">로그아웃</a>
</body>
</html>