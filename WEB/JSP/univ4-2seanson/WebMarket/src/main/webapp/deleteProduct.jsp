<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import = "java.sql.*"%>
<%@ include file = "dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "content-type" content="text/html; charset=utf-8">
<title>상품 삭제</title>
</head>
<body>
<%@ include file = "menu.jsp"%>
	<div class="jumbotron">
		<div class="container">
			<h1 class = "display-3">상품 삭제</h1>
		</div>
	</div>

<%
	String productId = request.getParameter("id");

	String sql = "select * from product";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	if(rs.next()){
		sql = "delete from product where p_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productId);
		pstmt.executeUpdate();
	}else out.println("일치하는 상품이 없습니다.");
	
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();
	if(conn !=null) conn.close();
	
	response.sendRedirect("editProduct.jsp?edit=delete");
%>
</body>
</html>