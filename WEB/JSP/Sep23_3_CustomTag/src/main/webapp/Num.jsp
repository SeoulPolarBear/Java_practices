<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>숫자 입력</title>
<script type="text/javascript" src="PolarbearValidChecker.js"></script>
<script type="text/javascript" src="ValidationOfNum.js"></script>
<link rel="stylesheet" href="CSS/Num.css">
</head>
<body>

<%
//비어있으면 안되고
//숫자이외의 값이 들어오면 막아버린다.
%>
<form action="NumController" onsubmit = "return validation();" name = "f">
<table id="total">
<tr>  <td>숫자1 :</td> <td><input placeholder="x" name = "num1" type="text"></td> </tr> 
<tr>  <td>숫자2 :</td> <td><input placeholder="y" name = "num2" type="text"></td> </tr> 
<tr>  <td colspan = "2"><button>계산</button></td></tr> 
</table>


</form>
</body>
</html>