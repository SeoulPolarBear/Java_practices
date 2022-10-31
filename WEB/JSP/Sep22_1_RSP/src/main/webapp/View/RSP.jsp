<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>가위바위보</title>
<link rel="stylesheet" href =" CSS/RSP.css">
</head>
<body>

<!--  <form action="HomeController" method = "get">-->
	<table border = "1" id = "total">
		<tr><th id= "title" colspan = "3">가위바위보</th></tr>
		
		<tr><td><a href = "HomeController?RSP=0"> 
		<img width = "200px" height = "200px" class = "weapon" alt="가위" src="CSS/0.PNG">
		</a></td>
		
		<td><a href = "HomeController?RSP=1"> 
		<img width = "200px" height = "200px" class = "weapon" alt="바위" src="CSS/1.PNG">
		</a></td>
		
		<td><a href = "HomeController?RSP=2"> 
		<img width = "200px" height = "200px" class = "weapon" alt="보" src="CSS/2.PNG">
		</a></td></tr>
<!-- 		<tr><td><button type = "submit"  name = "RSP" value ="0"> 
		<img width = "100px" height = "100px" class = "weapon" alt="가위" src="https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-switch/b/bd/Krabby.jpg">
		</button></td>
		
		<td><button type = "submit"  name = "RSP" value ="1"> 
		<img width = "100px" height = "100px" class = "weapon" alt="바위" src="https://pbs.twimg.com/profile_images/1520907310956105728/kplZbBDr_400x400.jpg">
		</button></td>
		
		<td><button type = "submit"  name = "RSP" value ="2"> 
		<img width = "100px" height = "100px" class = "weapon" alt="보" src="https://s.yimg.com/uu/api/res/1.2/IMszDZqyVCQTdU1EKLF8GA--~B/aD04NzU7dz0xNDAwO2FwcGlkPXl0YWNoeW9u/https://o.aolcdn.com/hss/storage/midas/b382da4b8b8d0c5df82691ee8b8eb197/204558745/Ditto.jpg">
		</button></td></tr> -->
		
		<tr> 
		<td>유저</td> 
		<td></td> 
		<td>상대</td> 		
		</tr>
		
		<tr> 
		<td><img width = "200px" height = "200px" class = "weapon" alt="가위바위보" src="CSS/${userimg}"></td> 
		<td><img width = "200px" height = "200px" class = "weapon" alt="가위바위보" src="CSS/vs.PNG"></td> 
		<td><img width = "200px" height = "200px" class = "weapon" alt="가위바위보" src="CSS/${attackerimg}"></td> 		
		</tr>
		<tr> 
		<td>${user}</td> 
		<td>VS</td> 
		<td>${attacker}</td> 		
		</tr>
		<tr>
		<td>판정</td> 
		<td colspan = "2"> ${result}</td> 
		</tr>
		<tr>
		<td>전적</td> 
		<td colspan = "2"> ${trying}전적 &nbsp&nbsp  ${win}승 &nbsp&nbsp ${draw}무 &nbsp&nbsp ${lose} 패</td> 
		</tr>	
	</table>

<!-- </form> -->
</body>
</html>