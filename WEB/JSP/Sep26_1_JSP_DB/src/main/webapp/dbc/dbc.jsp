<%@page import="java.sql.Connection"%>
<%@page import="com.polarbear.db.manager.PolarBearDBManager"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	//��Ĺ�� Ʃ��뿩�� ������ �� �� �˾Ƽ�
	// Ʃ�� = Connection ��ü
	// ���� : DriverManager.getConnection()�� �����ϴ� ����
	// ���õ� ��� �۾��� �ؼ� Connectin ��ü�� ����� �� => ����
	
	//Ŀ�ؼ�Ǯ : �̸� Connection��ü X100�� ��������
	//	Ŭ���̾�Ʈ�� ��û�ϸ� -> ��������� �ϳ� �ָ� �� => ����
	//	���� - context.xml(���赵, �����ȹ�� ����)
	//	Servers - context.xml
	//		���� �ǵ��...��ũ�����̽� �ȿ� �ִ� ��~~~�� ������Ʈ�� �� ����!!
	//		������Ʈ�� �ٸ��� -> DB������ �ٸ���
	
	//	�츮�� ���� context.xml�� �� ������Ʈ�� META-INF������ ����!
	
	String result = "";
	Connection con = null;
	try{
		con = PolarBearDBManager.connect("polarbearPool");
		result="����";
	}catch(Exception e){
		e.printStackTrace();
		result = "����";
	}
	PolarBearDBManager.close(con, null, null);
	%>
	
	<h1>DB����</h1>
	<h1><%= result %></h1>
</body>
</html>