<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "dto.Product" %>
<%@ page import = "dao.ProductRepository" %>
<!DOCTYPE html>
<html>
<head>
<title>세션 종료</title>
</head>
<body>
<%@ include file = "menu.jsp"%>
	<div class="jumbotron">
		<div class="container">
			<h1 class = "display-3">상품 목록</h1>
		</div>
	</div>

	<%
		String id = request.getParameter("cartId");
		if(id == null || id.trim().equals("")){
			response.sendRedirect("cart.jsp");
			return;
		}
		
		session.invalidate();
		
		response.sendRedirect("cart.jsp");
	%>
</body>
</html>