<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "./resources/css/bootstrap.min.css" />
<title>상품 편집</title>
<script type = "text/javascript">
	function deleteConfirm(id){
		if(confirm("해당 상품을 삭제합니다!!") == true)
			location.href = "./deleteProduct.jsp?id =" + id;
		else return;
	}
</script>
<%
	String edit = request.getParameter("edit");
%>
</head>
<body>
<!-- 상품 편집 페이지 -->
	<%@ include file = "menu.jsp"%>
	<div class="jumbotron">
		<div class="container">
			<h1 class = "display-3">상품 목록</h1>
		</div>
	</div>
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
		%><div class = "col-md-4">
				<img src = "c:/upload/<%=rs.getString("p_fileName")%>" style = "width: 100%">
				<h3><%=rs.getString("p_name")%></h3>
				<p><%=rs.getString("p_description")%>
				<p><%=rs.getString("p_UnitPrice")%>원
				<p><%
					if(edit.equals("update")){
					%>
				 <a href = "./updateProduct.jsp?id=<%=rs.getString("p_id")%>"
				Class = "btn btn-success" role = "button">수정 &raquo;</a>
			<%
			} else if(edit.equals("delete")){
			%>
			<a href = "#" onclick = "deleteConfirm('<%=rs.getString("p_id")%>')"
			class = "btn btn-danger" role = "button">삭제 &raquo;</a>
			<%
			}
			%>
			</div>
		<%
		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(conn !=null) conn.close();
		%>	
		
			</div>
		<hr>
	</div>
	<jsp:include page = "footer.jsp"/>
</body>
</html>