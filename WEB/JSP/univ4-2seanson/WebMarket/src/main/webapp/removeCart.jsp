<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "dto.Product" %>
<%@ page import = "dao.ProductRepository" %>
<!DOCTYPE html>
<html>
<head>
<title>장바구니 삭제</title>
</head>
<body>
<%@ include file = "menu.jsp"%>
	<div class="jumbotron">
		<div class="container">
			<h1 class = "display-3">상품 목록</h1>
		</div>
	</div>

<%
	String id = request.getParameter("id");
	if(id ==null|| id.trim().equals("")){//trim() 좌우 고백제거 함수
		response.sendRedirect("products.jsp");
		return;
	}
	
	ProductRepository dao = ProductRepository.getInstance();
	
	Product product = dao.getProductById(id);
	if(product == null){
		response.sendRedirect("exceptionNoProductId.jsp");
	}
	
	ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cartlist");
	Product goodsQnt = new Product();
	for(int i = 0; i < cartList.size(); i++){
		goodsQnt = cartList.get(i);
		if(goodsQnt.getProductId().equals(id)){
			cartList.remove(goodsQnt);
		}
	}
	response.sendRedirect("cart.jsp");
%>
</body>
</html>