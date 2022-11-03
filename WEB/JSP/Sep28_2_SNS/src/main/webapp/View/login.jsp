<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="loginController" method="post" name = "loginForm">
			<table>
				<tr>
					<th colspan= "2" align="center">${r }</th>
				</tr>
				<tr>
					<th colspan= "2" align="center">login</th>
				</tr>
				<tr>
					<td >ID &nbsp&nbsp&nbsp</td>
					<td><input type="text" name="m_id"></td>
				</tr>
				<tr>
					<td>PW &nbsp</td>
					<td><input type="password" name="m_passwd"></td>
				</tr>
				</table>
				<table align="right" >
			<tr>
				<tr>
					
					<td colspan="2" align="right" > <span ><button value="login" name="btn" id = "login-btn">login</button></span> 
					  </td>  
				</tr>
			</table>
			</form>
			<table align="right" >
			<tr><td colspan="2" > <span><button onclick="SignUp();"
					name="btn" value="signup" id = "sign-btn">sign up</button></span> 
					  </td></tr>
			</table>
			
</body>
</html>