<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<marquee><%= 123 * 877 %></marquee>

	HTML : ������Ʈ ���� ����
	--------------------------------������ / �̺�Ʈ ���� : �� �����, ������ �̺�Ʈ��...
	HTML : ���븦 �����
	CSS : ������
	JavaScript : �̺�Ʈ ó��
	--------------------------------- �Ķ���� �б�, ���, ���ǹ�, �ݺ��� : ���α׷��־�� ���� ����� ����
	Servlet : Ŭ���̾�Ʈ�� ��û�ϸ�
		=> HTML + CSS + JavaScript�� ���� �����ϴ� �ڹ����α׷�
	---------------------------------��ư�, �۾��� ����
	JSP(Java Servlet/Server Page)
		�۾� ���� : HTML + CSS + JavaScript�� �ʿ��� �κи��� Jav�ڵ带 ��¦ ÷��!
		���� ��ü : Tomcat�� Servlet���� �ٲ㼭 ����
		
	Servlet :�ڹ��ڵ� �ȿ��� HTML�� ����
	JSP : HTML�ȿ��� �ڹ��ڵ带 �߰�
	
	<%--
		1. ��ũ��Ʈ��(Scriptlet)
		JSP���� Java�ڵ带 ������ �� ����ϴ� ���
		<% Java�ڵ尡 ���⿡! %>
		
		2.������
		Ư���� ���ø� ���� �� �ֵ��� �ϴ� ���
		<%@page / include/ taglib / ...%>
		
		3. ǥ����
		� ���� (����������) ��� ����� ���Խ�Ű�� ���� �� ����ϴ� ���
		<%= ��/ ���� / ...%>
		����, ���ڿ�, ���� �� �� ��� ����
		servlet�� out.print()�� ���� ���
		
		4. ����
		ǥ���Ŀ��� ����� �� �ִ� Java�� method�� �ۼ��� �� ����ϴ� ���
		<%! �ɹ����� / method%>
		Java�� method�� ����(�̸� ��Ģ�� ����)
		
		5. �ּ�(�� ����� ���� ���°� �ּ�)
	--%>
	
</body>
</html>