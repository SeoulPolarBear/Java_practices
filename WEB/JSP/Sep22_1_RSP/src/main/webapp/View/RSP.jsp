<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����������</title>
<link rel="stylesheet" href =" CSS/RSP.css">
</head>
<body>

<!--  <form action="HomeController" method = "get">-->
	<table border = "1" id = "total">
		<tr><th id= "title" colspan = "3">����������</th></tr>
		
		<tr><td><a href = "HomeController?RSP=0"> 
		<img width = "200px" height = "200px" class = "weapon" alt="����" src="CSS/0.PNG">
		</a></td>
		
		<td><a href = "HomeController?RSP=1"> 
		<img width = "200px" height = "200px" class = "weapon" alt="����" src="CSS/1.PNG">
		</a></td>
		
		<td><a href = "HomeController?RSP=2"> 
		<img width = "200px" height = "200px" class = "weapon" alt="��" src="CSS/2.PNG">
		</a></td></tr>
<!-- 		<tr><td><button type = "submit"  name = "RSP" value ="0"> 
		<img width = "100px" height = "100px" class = "weapon" alt="����" src="https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-switch/b/bd/Krabby.jpg">
		</button></td>
		
		<td><button type = "submit"  name = "RSP" value ="1"> 
		<img width = "100px" height = "100px" class = "weapon" alt="����" src="https://pbs.twimg.com/profile_images/1520907310956105728/kplZbBDr_400x400.jpg">
		</button></td>
		
		<td><button type = "submit"  name = "RSP" value ="2"> 
		<img width = "100px" height = "100px" class = "weapon" alt="��" src="https://s.yimg.com/uu/api/res/1.2/IMszDZqyVCQTdU1EKLF8GA--~B/aD04NzU7dz0xNDAwO2FwcGlkPXl0YWNoeW9u/https://o.aolcdn.com/hss/storage/midas/b382da4b8b8d0c5df82691ee8b8eb197/204558745/Ditto.jpg">
		</button></td></tr> -->
		
		<tr> 
		<td>����</td> 
		<td></td> 
		<td>���</td> 		
		</tr>
		
		<tr> 
		<td><img width = "200px" height = "200px" class = "weapon" alt="����������" src="CSS/${userimg}"></td> 
		<td><img width = "200px" height = "200px" class = "weapon" alt="����������" src="CSS/vs.PNG"></td> 
		<td><img width = "200px" height = "200px" class = "weapon" alt="����������" src="CSS/${attackerimg}"></td> 		
		</tr>
		<tr> 
		<td>${user}</td> 
		<td>VS</td> 
		<td>${attacker}</td> 		
		</tr>
		<tr>
		<td>����</td> 
		<td colspan = "2"> ${result}</td> 
		</tr>
		<tr>
		<td>����</td> 
		<td colspan = "2"> ${trying}���� &nbsp&nbsp  ${win}�� &nbsp&nbsp ${draw}�� &nbsp&nbsp ${lose} ��</td> 
		</tr>	
	</table>

<!-- </form> -->
</body>
</html>