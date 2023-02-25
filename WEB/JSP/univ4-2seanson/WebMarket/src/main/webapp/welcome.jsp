<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>

	<%@ include file = "menu.jsp" %>
	<%! String greeting = "전통주 시장에 오신걸 환영합니다.";
	String tagline = "Welcome to Traditional Alcohol Market!"; %>
	<div class="jumbotron">
		<div class="container">
			<h1 class = "display-3"><%= greeting %></h1>
		</div>
	</div>
	<main role = "main">
	<div class="container">
		<div class="text-center">
			<h3><%= tagline %></h3>
			<%
			response.setIntHeader("Refresh", 5);
			Date day = new java.util.Date();
			String am_pm;
			int hour = day.getHours();
			int minute = day.getMinutes();
			int second = day.getSeconds();
			if(hour/12 ==0){
				am_pm = "AM";
			}
			
			else{
				am_pm = "PM";
				hour -=12;
			}
			String CT = hour + ":" + minute + ":" + second + " " + am_pm;
			out.println("현재 접속 시각: " + CT + "\n");
			%>
		</div>
		<hr>
	</div>
	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html> 