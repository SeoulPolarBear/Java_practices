<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����� ����</title>
</head>
<body>
<%
	// GET / POST
	// ����) ��û�Ķ���� -> �ѱ�ó��
	// 		GET - �� ��
	//		POST - �ؾ���
	// encoding ���� ���� ����� �� ���� �ϴ� �ϰ���!
	request.setCharacterEncoding("EUC-KR");
	String name = request.getParameter("name");
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	// ����) ���� �ѱ� ó��(������ ���ְ� �־ �ʿ���� !)
	//response.setCharacterEncoding("EUC-KR");

	int z = x + y;
%>

�̸� : <%= name %><p>
<h1> <%= x%> +  <%= y%> =  <%= z %> </h1>
</body>
</html>