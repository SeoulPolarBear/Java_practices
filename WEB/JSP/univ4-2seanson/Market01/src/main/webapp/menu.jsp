<%@ page language="java" contentType="text/html; charset=utf-8"%>
<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class = "navbar-brand" href="./welcome.jsp">home</a>
		</div>
		<div>
			<ul class = "navbar-nav mr-auto">
				<li class = "nav-item">
				<a class = "nav-link" href = "./products.jsp">상품 목록</a></li>
				<li class = "nav-item">
				<a class = "nav-link" href = "./addproduct.jsp">상품 등록</a></li>
				<li class = "nav-item">
				<a class = "nav-link" href = "./editproduct.jsp?
				edit=update">상품 수정</a></li>
				<li class = "nav-item">
				<a class = "nav-link" href = "./editproduct.jsp?
				edit=delete">상품 삭제</a></li>
			</ul>
		</div>
	</div>
</nav>