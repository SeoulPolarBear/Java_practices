<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Implicit Objects</title>
</head>
<body>
	<p>���۵� ��û �Ķ���� : 
	<% //getQueryString() �޼ҵ带 �̿��Ͽ�_�� ������ �ּ���"?"������ ���ڿ��� ����մϴ�.
	out.print(request.getQueryString());
	%>
</body>
</html>