<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "dto.Product" %>
<%@ page import = "dao.ProductRepository" %>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>장바구니</title>
</head>
<body>
<%@ include file = "menu.jsp"%>
	<div class="jumbotron">
		<div class="container">
			<h1 class = "display-3">상품 목록</h1>
		</div>
	</div>
	<%@ include file = "dbconn.jsp"%>
	<%
	String alcohol_id = request.getParameter("id");
	Statement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from product where p_id = '" + alcohol_id +"'";
	pstmt = conn.createStatement();
	rs = pstmt.executeQuery(sql);
	
	String id = rs.getString("p_id");
	
		if(id == null || id.trim().equals("")){
			response.sendRedirect("products.jsp");
			return;
		}
		
		ProductRepository dao = ProductRepository.getInstance();
		
		Product product = dao.getProductById(id);
		if(product == null){
			response.sendRedirect("exceptionNoProductId.jsp");
		}
		ArrayList<Product>goodsList = dao.getAllProducts();
		Product goods = new Product();
		for(int i = 0; i < goodsList.size(); i++){
			goods = goodsList.get(i);
				if(goods.getProductId().equals(id)){
					break;
				}
		}
		ArrayList<Product> list = (ArrayList<Product>)session.getAttribute("carlist");
		if(list == null){
			list = new ArrayList<Product>();
			session.setAttribute("cartlist", list);
		}
		
		int cnt = 0;
		Product goodsQnt = new Product();
		for(int i = 0; i < list.size(); i++){
			goodsQnt = list.get(i);
			if(goodsQnt.getProductId().equals(id)){
				cnt++;
				int orderQuantity = goodsQnt.getQuantity() + 1;
				goodsQnt.setQuantity(orderQuantity);
			}
		}
		
		if(cnt == 0){
			goods.setQuantity(1);
			list.add(goods);
		}
		
		response.sendRedirect("products.jsp?id = " + id);
	%>
</body>
</html>