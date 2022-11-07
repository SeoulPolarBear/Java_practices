<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
	<script type="text/javascript" src ="../js/jQuery.js"></script>
	<script type="text/javascript">
		$(function(){
			alert("asdf");
			//""
			
		$("button").click(function(){
			let iVal = $("input").val();
			let REST_API_KEY = "";
			// $.getJSON 기능이 딸려서... -> 요청 헤더처리를 못해요ㅠㅠ
			$.ajax({
				url: "https://dapi.kakao.com/v3/search/book",
				data: {
					query : iVal
				},
				beforeSend: function(req){//요청 보내기 전에 콜백함수
					req.setRequestHeader(`Authorization: KakaoAK ${REST_API_KEY}`);
				},
				success: function(){
					alert(JSON.stringify(bookJSON));
					//테이블을 만들건데...
					//이미지사진 / 책 제목 - 출판사 / 정가 /판매가
					$("table").empty();
					$.each(bookJSON.documents, function(i,b){
						alert(b.title);
						let img = $("<img>").attr("src",b.thumbnail);
						let td1 = $("<td></td>").text(img);
						let td1 = $("<td></td>").text(b.thumbnail);
						let td2 = $("<td></td>").text(b.title + "-" + b.publisher);
						let td3 = $("<td></td>").text(b.price + "원");
						let td4 = $("<td></td>").text(b.sale_price + "원");
						
						let tr = $("<tr></tr>").append(td1,td2,td3,td4);
						$("table").append(tr);
					});
					
					let th1 = $("<th></th>").text("img");
					let th2 = $("<th></th>").text("title");
					let th3 = $("<th></th>").text("price");
					let th4 = $("<th></th>").text("sale_price");
					
					let trr = $("<tr></tr>").append(th1,th2,th3,th4);
					$("table").append(trr);
				}
			});
		});	
			$("input").keyup(function(){
				$("button").trigger("click");
			});
		});
	</script>
</head>
<body>
	<input>
	<button>찾기</button>
	<hr>
	<table border = "1"></table>
</body>
</html>