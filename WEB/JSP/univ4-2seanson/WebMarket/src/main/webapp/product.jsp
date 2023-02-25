<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Product" %>
<%@ page import="dao.ProductRepository" %>
<%@page errorPage = "exceptionNoProductId.jsp" %>
<%@ page import = "java.sql.*" %>
<html>
<head>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel = "stylesheet" href = "./resources/css/bootstrap.min.css" />
<title>상품 상세 정보</title>
<script type = "text/javascript">
	function addToCart() {
		if(confirm("상품을 장바구니에 추가하시겠습니까?")){
			document.addForm.submit();
		}else {
			document.addForm.reset();
		}
	}
	
</script>
</head>    
<body>
<%@ include file = "dbconn.jsp"%>

<jsp:include page = "menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class = "display-3">상품 정보</h1>
		</div>
	</div>
	
	<%
	/*String id = request.getParameter("id");
	ProductRepository dao = ProductRepository.getInstance();
	Product product = dao.getProductById(id);*/
	%>
	
	<%
			String alcohol_id = request.getParameter("alcohol_id");
			Statement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from product where p_id = '" + alcohol_id +"'";
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql);
			//while(rs.next()){
		%>
		
	<div class ="container">
		<div class = "row">
			<div class = "col-md-5">
				<img src="c:/upload/<%=rs.getString("p_fileName")%>" style = "width: 100%">
			</div>
			<div class = "col-md-6">
			<h3><%=rs.getString("p_name")%></h3>
			<p><%=rs.getString("p_description") %>
			<p><b>상품 코드 : </b> <span class="badge badge-danger">
			<%=rs.getString("p_id") %></span>
			<p> <b>도수</b> : <%=rs.getString("p_alcohol")%>
			<p> <b>분류</b> : <%=rs.getString("p_category")%>
			<p> <b>재고 수</b> : <%=rs.getLong("p_unitsInStock") %>
			<h4><%=rs.getInt("p_unitPrice") %>원</h4>
			<p><form name = "addForm" action = "./addCart.jsp?id=<%=rs.getString("p_name")%>"
			method = "post">
			<p> <a href = "#" class = "btn btn-info" onclick="addCart()">상품 주문 &raquo;</a>
				<a href = "./cart.jsp" class = "btn btn-warning">장바구니 &raquo;</a>
				<a href = "./products.jsp" class = "btn btn-secondary">상품 목록 &raquo;</a>
			</form>
			</div>
		</div>
		<hr>
	</div>
	<%
			//}
			%>
		<%
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(conn !=null) conn.close();
		%>
	<jsp:include page = "footer.jsp" />
</body>
</html>