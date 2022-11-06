<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	let ar = [];
	$(function() {

		$.getJSON("http://localhost/oct071/getAllError.JSON", function(x) {
			/* alert(JSON.stringify(x));
			console.log(JSON.stringify(x)); */
		});

		$.ajax({
			url : "k.weather.get",
			success : function(y) {

				/* alert(y);
				console.log(y); */

				let hourTh = $("<th></th>").text("시간");
				let tempTh = $("<th></th>").text("기온");
				let wfKorTh = $("<th></th>").text("날씨");
				let Tr = $("<tr></tr>").append(hourTh, tempTh, wfKorTh);
				$("#weatherTbl").append(Tr);
				$(y).find("data").each(function(i, d) {

					let hour = $(d).find("hour").text();
					let temp = $(d).find("temp").text();
					let wfKor = $(d).find("wfKor").text();

					let hourTd = $("<th></th>").text(hour);
					let tempTd = $("<td></td>").text(temp);
					let wfKorTd = $("<td></td>").text(wfKor);

					let Tr2 = $("<tr></tr>").append(hourTd, tempTd, wfKorTd);
					$("#weatherTbl").append(Tr2);

					ar[i] = {
						label : hour,
						y : temp * 1
					};
				});
				// ajax는 동기식이므로 data를 먼저 가져오기 때문에 나중에 data를 사용할 경우
				//오류가 발생할 수 있다. 따라서 사용할 부분을 같은 function에 넣어 주는 것이 좋다.
				var chart = new CanvasJS.Chart("chartContainer", {
					animationEnabled : true,
					theme : "light2",
					title : {
						text : "Simple Line Chart"
					},
					data : [ {
						type : "line",
						indexLabelFontSize : 16,
						dataPoints : ar
					} ]
				});
				chart.render();

			}
		});

	});
</script>
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<table id="weatherTbl" border="1"></table>

</body>
</html>