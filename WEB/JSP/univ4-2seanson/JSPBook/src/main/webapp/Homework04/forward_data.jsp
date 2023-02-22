<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Tag</title>
</head>
<body>
	<% 
    String number=request.getParameter("five");    
    int five = Integer.parseInt(number);
    for(int i=1;i<=9;i++)
    {
        out.println(five+"*"+i+"="+five*i+"<br>");
    }
%>
</body>
</html>