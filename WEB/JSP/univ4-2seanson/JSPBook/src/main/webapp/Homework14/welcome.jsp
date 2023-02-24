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
	Cookie[] user_id=request.getCookies();
if(user_id[0]==null){
	response.sendRedirect("cookie_out.jsp");
		}
	out.println(user_id[0].getName() + "님 반갑습니다");
%>
<p><a href = "cookie_out.jsp">로그아웃</a>
</body>
</html>