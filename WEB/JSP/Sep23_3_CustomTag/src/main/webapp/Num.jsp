<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �Է�</title>
<script type="text/javascript" src="PolarbearValidChecker.js"></script>
<script type="text/javascript" src="ValidationOfNum.js"></script>
<link rel="stylesheet" href="CSS/Num.css">
</head>
<body>

<%
//��������� �ȵǰ�
//�����̿��� ���� ������ ���ƹ�����.
%>
<form action="NumController" onsubmit = "return validation();" name = "f">
<table id="total">
<tr>  <td>����1 :</td> <td><input placeholder="x" name = "num1" type="text"></td> </tr> 
<tr>  <td>����2 :</td> <td><input placeholder="y" name = "num2" type="text"></td> </tr> 
<tr>  <td colspan = "2"><button>���</button></td></tr> 
</table>


</form>
</body>
</html>