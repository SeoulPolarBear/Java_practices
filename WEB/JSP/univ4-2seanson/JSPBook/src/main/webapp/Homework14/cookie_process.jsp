<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Cookie</title>
</head>
<body>
	<%
	String user_id=request.getParameter("id");
	String user_pw=request.getParameter("passwd");
	
	if(user_id.equals("admin")&&user_pw.equals("1234")){
		Cookie cookieID = new Cookie("userID",user_id);
		response.addCookie(cookieID);
		response.sendRedirect("welcome.jsp");
	}else{
		out.println("세션 연결에 실패했습니다.");
	}
	%>
</body>
</html>