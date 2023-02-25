<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "content-type" content="text/html; charset=utf-8">
</head>
<body>
	<%
	Connection conn = null;
	
	try{
		String url = "jdbc:mysql://localhost:3306/WebMarketDB?characterEncoding=euckr";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,password);
	} catch(SQLException ex) {
		out.println("데이터베이스 연결이 실패했습니다.<br>");
		out.println("SQLException: " + ex.getMessage());
	}
	%>
</body>
</html>