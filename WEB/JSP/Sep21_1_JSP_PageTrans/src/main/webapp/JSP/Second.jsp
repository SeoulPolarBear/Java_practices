<%@page import="java.util.Random"%>
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
	//��	�⺻ ���̽��� ��� ���������� �������� ������ �ؾ� �Ѵ�.
	//		parameter
	//			html���� ���� �� (a,b)
	//			��û(request)�� ����
	//			String or String[]
	
			
			
	//		attribute
	//			Java���� ���� ��(c, d, e)
	//			request�� ����
	//			Object(��ü)�� ����
	
	// �̵�
	//			first -> second : ����ڰ� ���� �׼��� �ؼ� �Ѿ��
	//			- request(��û)
	
	//			second -> third : �׳� �Ѿ
	//				- redirect : �ܼ��� �ڵ��̵�(���� ��)
	//					request.sendRedirect("Third.jsp");
	
	//				- forward : �ڵ��̵�(���� ���޵Ǵ�)
	//					RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	//					rd.forward(request, response);
	
	//				- include : ����(Second�ӿ� Third�� ���ԵǴ�)
	//					��ġ������ �ȵ�(Third�� ������ ��ܿ� ����) - ����!
	//					������ ! ��ġ������ �Ǵ� include�� ������ ����~
	//				RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	//				rd.include(request, response);
	%>


	<%
	request.setCharacterEncoding("EUC-KR");

	double x = Double.parseDouble(request.getParameter("x"));
	double y = Double.parseDouble(request.getParameter("y"));

	RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	double c = x + y;

	//RequestDispatcher : Ŭ���̾�Ʈ�κ��� ���� ��û�� 
	//						���ϴ� ������ �ѱ�� ���
	// ȣ��� ������������ request.setAttribute(key, value); �޼ҵ带 ���ؼ�
	// �Ѱܹ��� �����͸� ó���� �� ����
	// -> Redirect�ʹ� �ٸ��� (������ ó�� �Ұ�)
	//	���� : response.sendRedirect�� response�� ����
	//	rd.forward(request,response); �� req, res ��ü �Ѵ� �����ؼ� data�� ó���� �� �ִ�.

	request.setAttribute("c", c);

	String d = "��";
	request.setAttribute("d", d);

	Random e = new Random();
	request.setAttribute("e", e);

	rd.forward(request, response);
	//rd.include(request,response);
	%>
	<h1><%=x%></h1>
	<h1><%=y%></h1>

</body>
</html>