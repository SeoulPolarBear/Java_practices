<%@page import="java.util.ArrayList"%>
<%@page import="com.polarbear.sep214.main.Polarbear"%>
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
// EL (Expression Language)
//		�� ���� �� Java ��� ����
//		.jsp������ ��밡��(o)
//		.jsp������ ��밡��(.jsp�� ��Ĺ�� Servlet���� �ٲ� �� EL�� Java�ڵ�� �ٲ���)
//		���� : ${ xxx }
//			������ ��� ����
//			�� ��ȯ �ڵ�
//			���� ������ �׳� �Ѿ
//			import�� ��� �� !

//		�Ķ���Ͱ� �б� : ${param.�Ķ���͸� }
//		��Ʈ����Ʈ�� �б�(int, double, String, ... ����)
//				: ${��Ʈ����Ʈ��}

//		��Ʈ����Ʈ�� �б�(��ü)
//				�ּҰ� - ${��Ʈ����Ʈ��}
//				�Ӽ��� - ${��Ʈ����Ʈ��.���������}

//		��Ʈ����Ʈ�� �б�(List, [])
//				AL / [] ��ü 			- ${ ��Ʈ����Ʈ�� }
//				�ε��� ��ġ�� ��ü		- ${��Ʈ����Ʈ��[�ε���]}
//				�ε��� ��ġ�� ��ü �Ӽ� - ${��Ʈ����Ʈ��[�ε���].��������� }
//		�ݺ���, ���ǹ� - EL (X) �Ұ��� �ϴ�. / CustomTag (o)

%>
<%
//getParameter("x")��  form tag�� ?A=asdfasdf �̷� ������ �� ���
//getAttribute("x")�� setAttribute�� ���� �� ���

	String x = request.getParameter("x");
	String y = request.getParameter("y");
	double z = (Double) request.getAttribute("z");
	
	Polarbear pb = (Polarbear) request.getAttribute("b");
	ArrayList<Polarbear> pbvs = (ArrayList<Polarbear>) request.getAttribute("pbvs");
%> 

<h1>���</h1>
${param.x} <p>
${param.y} <p>
${param.x * param.y} <p>

${z} <p>
${b.name} <p>
${b.age} <p>
${b.height} <p>
${b.weight} <p>
<hr>
<!-- �����ϰ� �Ѿ�� �� ���̹Ƿ� -->
${param.asdgwqegqweg}

${bvs} <p>
${bvs[1]} <p>
${bvs[2].name} <p>
${bvs[3].age} <p>
${bvs[4].weight} <p>
${bvsp[5].height} <p>


${z} <p>



</body>
</html>