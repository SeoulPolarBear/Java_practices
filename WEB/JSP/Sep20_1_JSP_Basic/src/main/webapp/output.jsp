<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function getRandomColor(){
		//Math.random() 					-> 0.0 ~ 0.99999
		//Math.random() * 255				-> 0.0 ~ 254.99999
		//Math.round(Math.random() * 255)	-> 0 ~ 255
		
		let r = Math.round(Math.random() * 255);
		let g = Math.round(Math.random() * 255);
		let b = Math.round(Math.random() * 255);
		
		return "rgb(" + r + "," + g + "," + b + ")";
	}
	
	function init(){
		let cv = document.getElementById("cv");
		let pen = cv.getContext("2d");
		let x = null;
		let y = null;
		
		setInterval(() => {
			pen.save();//현재 pen상태 저장
			pen.fillStyle = "rgba(0,0,0,0.2)";//투명도 : 0 ~ 1
			pen.fillRect(0,0,500, 500);
			
			pen.shadowOffsetX = 0;
			pen.shadowOffsetY = 0;
			pen.shadowBlur = 5;
			pen.shadowColor = "white";
			
			x = Math.random() * 500;
			y = Math.random() * 500;
			pen.fillStyle = getRandomColor();
			pen.fillRect(x,y,20,20);
			
			pen.restore();//이전 설정으로
		}, 200);
	}
</script>
</head>
<body onload="init();">
	<canvas id="cv" width="500px" height="500px"></canvas>
	<hr>
	<%
	response.sendRedirect("test.jsp");
	
	request.setCharacterEncoding("EUC-KR");
	String str = request.getParameter("str");
	
	String[] array = str.split(",");
	int sum1 = 0;
	
	for(String n : array){
	try{
		sum1 += Integer.parseInt(n);
	}catch(Exception e){
		continue;
	}	
		}
	
	StringTokenizer st = new StringTokenizer(str, ",");
	int sum2 = 0;
	while(st.hasMoreTokens()){
		try{
			sum2 += Integer.parseInt(st.nextToken());
		}catch(Exception e){
			continue;
		}	
	}
	%>
	합(Split) : <%= sum1 %> <br>
	합(StringTokenizer) : <%= sum2 %> <br>
	

</body>
</html>