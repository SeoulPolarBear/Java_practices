<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function(){
		//AJAX (Asynchronous JavaScript And XML)
		$("#btn").click(function(){
			//AJAX 진행
			$.ajax({	//함수 X, 객체 O
				url:"fruit.getXML",//url속성에 value값(Controller에 설정한 요청 주소)
				success : function(x){//요청에 성공하면 function 동작
					//alert(x); //XML문서라는게 확인
					
					//DOM객체 하나 불러올때마다 나오는 콜백함수  i : index, 
					//f : $(x).find("fruit")의 fruit 한 덩어리
					$(x).find("fruit").each(function(i, f){
					let f_name = $(f).find("f_name").text();
					let f_price = $(f).find("f_price").text();
				/* 	let str ="<th><td>" + f_name + "- \\" + f_price + "</th></td>";
					$("#fruitTbl").append(str); */
					});
				}
			});
		});
		
		// fruit.getXML에 요청해서
		// 나오는 모든 데이터들을 가지고
		// 테이블을 구성해주세요!
	/* 	$.ajax({
			url: "fruit.getXML",
			success: function(x){
				$(x).find("fruit").each(function(i,f){
					let f_name = $(f).find("f_name").text();
					let f_price = $(f).find("f_price").text();
					
					let nameId = $("<td></td>").text(f_name);
					let priceId = $("<td></td>").text( "\\" + f_price);
					
					let tr = $("<tr></tr>").append(nameId,priceId);
					
					$("#fruitTbl").append(tr);
				});
			}
		}); */	
		$("#fruitSearchBtn").click(function(){
			let fruitInput = $("#fruitInput").val();
			$.ajax({
				//url: "fruitPrice.getXML?f_price=" + fruitInput,
				url: "fruitPrice.getXML",
				dataType: 'xml',
				data: {f_price : fruitInput},
				success: function(x){
					$("#fruitTbl").empty();
					$(x).find("fruit").each(function(i,f){
						let f_name = $(f).find("f_name").text();
						let f_price = $(f).find("f_price").text();
						
							let nameId = $("<td></td>").text(f_name);
							let priceId = $("<td></td>").text( "\\" + f_price);
							
							let tr = $("<tr></tr>").append(nameId,priceId);
							$("#fruitTbl").append(tr);
					});
				}
			});
		});
		
		$("#fruitInput").keyup(function(e){
			if(e.keyCode == 13){
				//keyboard에서 손을 때는 즉시 버튼을 클릭한 것과 같은 trigger를 주게 된다.
				$("#fruitSearchBtn").trigger("click");
			}
		});
	});
</script>
</head>
<body>
	<table id="fruitTbl" border="1">
	</table>
	<hr>
	<input id="fruitInput">
	<button id="fruitSearchBtn">검색</button>
	<button id="btn">버튼</button>
</body>
</html>