<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "dto.Product" %>
<%@ page import = "dao.ProductRepository" %> 
<!DOCTYPE html>
<html>
<head>
<title>장바구니</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
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
		
		response.sendRedirect("Product.jsp?id = " + id);
	%>
</body>
</html>