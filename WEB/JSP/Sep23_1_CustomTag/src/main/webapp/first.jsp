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
	//JSP Model 2
	// View(.jsp)
	//		�� �ޱ� : EL ${}
	
	// ������ �̵�
	//	redirect, forward, include
	
	// ���ǹ�, �ݺ���
	// ������� (�Ҽ���, ��¥ ����, ...)
	
	// CustomTag
	//		������� HTML DOM��ü
	//		.JSP -> servlet���� �ٲ� �� java�� ��ȯ!
	//			=> .JSP������ ��� ���� O
	//		<���ξ�: �±׸�>
	//			<xxx:table></xxx:table>		=> ���� �ݱ� �� ������!
	//			<xxx:table />				=> ���� �ݱ� ���̿� ������ ������
	
	//	JSPǥ�ؾ׼��±�
	//		JSPȯ�濡�� �⺻������ ��� ����
	//		�� ���ξ jsp
	//		forward, include, ...
	//	Ŀ�����±�
	//		�ܺ� .jar�� �ְ� ����� ��(jstl)
	//		���ξ �������...
	//		�ݺ���, ���ǹ�, �������, ...
%>
<h1>First</h1>
<!-- second.jsp�� �ҽ��� �Ʒ��� -->
<!-- *** ���ϴ� �ڸ��� �־ ǥ���� �� �ִٴ°� ���� -->
<jsp:include page="second.jsp"></jsp:include>


<h2>Third</h2>
























</body>
</html>