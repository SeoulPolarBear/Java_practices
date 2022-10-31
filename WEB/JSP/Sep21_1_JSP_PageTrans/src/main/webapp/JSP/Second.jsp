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
	//값	기본 베이스는 어디서 보내는지를 기준으로 생각을 해야 한다.
	//		parameter
	//			html에서 만들어낸 값 (a,b)
	//			요청(request)에 저장
	//			String or String[]
	
			
			
	//		attribute
	//			Java에서 만들어낸 값(c, d, e)
	//			request에 저장
	//			Object(객체)로 저장
	
	// 이동
	//			first -> second : 사용자가 뭔가 액션을 해서 넘어옴
	//			- request(요청)
	
	//			second -> third : 그냥 넘어감
	//				- redirect : 단순히 자동이동(점검 중)
	//					request.sendRedirect("Third.jsp");
	
	//				- forward : 자동이동(값이 전달되는)
	//					RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	//					rd.forward(request, response);
	
	//				- include : 포함(Second속에 Third가 포함되는)
	//					위치조절은 안됨(Third가 무조건 상단에 들어옴) - 비추!
	//					조만간 ! 위치조절이 되는 include를 보도록 하자~
	//				RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	//				rd.include(request, response);
	%>


	<%
	request.setCharacterEncoding("EUC-KR");

	double x = Double.parseDouble(request.getParameter("x"));
	double y = Double.parseDouble(request.getParameter("y"));

	RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	double c = x + y;

	//RequestDispatcher : 클라이언트로부터 들어온 요청을 
	//						원하는 쪽으로 넘기는 기능
	// 호출된 페이지에서는 request.setAttribute(key, value); 메소드를 통해서
	// 넘겨받은 데이터를 처리할 수 있음
	// -> Redirect와는 다른데 (데이터 처리 불가)
	//	이유 : response.sendRedirect는 response만 존재
	//	rd.forward(request,response); 즉 req, res 객체 둘다 존재해서 data를 처리할 수 있다.

	request.setAttribute("c", c);

	String d = "ㅋ";
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