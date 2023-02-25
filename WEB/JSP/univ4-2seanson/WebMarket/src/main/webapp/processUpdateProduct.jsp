<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import = "com.oreilly.servlet.*" %>
<%@ page import = "com.oreilly.servlet.multipart.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ include file = "dbconn.jsp" %>

<%
		request.setCharacterEncoding("UTF-8");
		
		String filename = "";
		String realFolder = "C:\\upload"; //웹 애플리케이션상의 절대 경로
		int maxSize = 5 * 1024 * 1024;//최대 업로드될 파일의 크기 5MB
		String encType = "utf-8"; //인코딩 유형
		
		MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType,
				new DefaultFileRenamePolicy());
		
		String productId=multi.getParameter("productId");
		String name = multi.getParameter("name");
		String unitPrice=multi.getParameter("unitPrice");
		String description=multi.getParameter("description");
		String alcohol=multi.getParameter("alcohol");
		String category=multi.getParameter("category");
		String unitsInStock=multi.getParameter("unitsInStock");
		String condition=multi.getParameter("condition");
		
		Integer price;
		
		if(unitPrice.isEmpty())
			price=0;
		else 
			price=Integer.valueOf(unitPrice);//valueOf는 String 이던 unitPrice를 integer로 변환시 사용
		
		long stock;
		
		if(unitsInStock.isEmpty())
			stock=0;
		else 
			stock=Long.valueOf(unitsInStock);//valueOf는 String 이던 unitsInStock를 Long로 변환시 사용

		Enumeration files = multi.getFileNames();
		String fname = (String) files.nextElement();
		String fileName = multi.getFilesystemName(fname);//업로드한 파일을 가져온다.
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from product where P_id = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,productId);
		rs = pstmt.executeQuery();
		if(rs.next()){
			if(fileName !=null){
				sql = "UPDATE product SET p_name = ?, p_unitPrice = ?, p_description = ?, p_category = ?, p_alcohol = ?,  p_unitsInStock = ?, p_fileName = ? where P_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setInt(2,price);
				pstmt.setString(3,description);
				pstmt.setString(5,alcohol);
				pstmt.setString(4,category);
				pstmt.setLong(6,stock);
				pstmt.setString(8,fileName);
				pstmt.setString(9,productId);
				pstmt.executeUpdate();
			}else{
				sql = "UPDATE product SET p_name = ?, p_unitPrice = ?, p_description = ?, p_category = ?, p_alcohol = ?, p_unitsInStock = ? where P_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setInt(2,price);
				pstmt.setString(3,description);
				pstmt.setString(4,category);
				pstmt.setString(5,alcohol);
				pstmt.setLong(6,stock);
				pstmt.setString(9,productId);
				pstmt.executeUpdate();
			}
		}
		
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(conn !=null) conn.close();
		
		response.sendRedirect("editProduct.jsp?edit=update");
%>
<!DOCTYPE html>
<meta http-equiv = "content-type" content="text/html; charset=utf-8">
