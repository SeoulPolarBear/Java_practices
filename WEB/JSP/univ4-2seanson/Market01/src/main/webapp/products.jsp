<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Product" %>
<%@ page import= "dao.ProductRepository"%>
<%@ page import= "java.sql.*"%>

<html>
<head>
<meta http-equiv = "content-type" content="text/html; charset=utf-8">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel = "stylesheet" href = "./resources/css/bootstrap.min.css" />
<title>상품목록</title>
</head>    
<body>
<jsp:include page = "menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class = "display-3">상품 목록</h1>
		</div>
	</div>
	<%
	ProductRepository dao = ProductRepository.getInstance();
	/* private는 new를 통해서 객체 생성을 
	못하므로 new 대신 getInstance()라는 메소드를 만들어서 이용한다.*/
	ArrayList<Product> listOfProducts = dao.getAllProducts();
	%>
	<div class="container">
		<div class="row" align = "center">
		<%@ include file = "dbconn.jsp"%>
		<%
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
		%>
<%--<% --%>
<!-- for (int i = 0; i < listOfProducts.size(); i++){ -->
<!--  Product product = listOfProducts.get(i); -->
<%-- %> --%>
			<div class = "col-md-4">
				<img src = "c:/upload/<%=rs.getString("p_fileName")%>" style = "width: 100%">
				<h3><%=rs.getString("p_name")%></h3>
				<p><%=rs.getString("p_description")%>
				<p><%=rs.getString("p_UnitPrice")%>원
				<p> <a href = "./product.jsp?id=<%=rs.getString("p_id")%>"
				Class = "btn btn-secondary" role = "button">상세 정보 &raquo;</a>
			</div>
			<%
			}
			%>
		<%
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(conn !=null) conn.close();
		%>	
		
			</div>
		<hr>
	</div>
	<%@ include file = "footer.jsp" %>
</body>
</html>