<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function() {

		/* 	$.ajax({
		 url:"getAllError.JSON",
		 success: function(j){
		 //alert(j);
		 // JavaScript 객체 -> 문자열 그래도 변환이 가능 O
		 //alert(JSON.stringify(j));
		
		
		 }
		 }); */
		//JSON으로 AJAX하기 간단한 Ver.
		// $.getJSON("요청주소?파라미터 = 값&...", 값을 받아오는데 성공하면 발동하는 콜백함수)
		/* $.getJSON("getAllError.JSON", function(x){
			//alert(x);
			//let ar = x.errors;
			
			//jQuery의 반복문 - 배열을 대상으로...
			
			$.each(x.errors,function(i,e){
				let td1 = $("<td></td>").text(e.e_what);
				let td2 = $("<td></td>").text(e.e_where);

				let tr = $("<tr></tr>").append(td1,td2);
				$("#errorTbl").append(tr);
			}); 
		});*/

		//버튼을 클릭하면 -> input에 e_what에 대한 내용이 error테이블에 있으면
		//	->그 데이터를 테이블의 형태로 출력
		$("#buttonsearch").click(function() {

			let inpputkeyword = $("#inpputkeyword").val();
			$.getJSON(
			//"getSearchError.JSON?e_what=" + inpputkeyword,
			"getSearchError.JSON?", {
				"e_what" : inpputkeyword
			}, function(x) {
				$("#errorTbl").empty();
				console.log(x.errors);
				$.each(x.errors, function(i, e) {

					let td1 = $("<td></td>").text(e.e_what);
					let td2 = $("<td></td>").text(e.e_where);

					let tr = $("<tr></tr>").append(td1, td2);
					$("#errorTbl").append(tr);
				});
			});
		});

		$("input").keyup(function(e) {
			if (e.keyCode == 13) {
				$(buttonsearch).trigger("click");
			}
		})

	});
</script>
</head>
<body>

	<input id="inpputkeyword">
	<button id="buttonsearch">button</button>

	<table border="1" id="errorTbl">
	</table>
</body>
</html>









