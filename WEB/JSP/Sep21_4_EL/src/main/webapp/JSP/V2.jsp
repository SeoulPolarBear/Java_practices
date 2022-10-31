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
//		값 받을 때 Java 대신 가능
//		.jsp에서만 사용가능(o)
//		.jsp에서만 사용가능(.jsp를 톰캣이 Servlet으로 바꿀 때 EL을 Java코드로 바꿔줌)
//		문법 : ${ xxx }
//			연산자 사용 가능
//			형 변환 자동
//			값이 없으면 그냥 넘어감
//			import가 없어도 됨 !

//		파라미터값 읽기 : ${param.파라미터명 }
//		어트리뷰트값 읽기(int, double, String, ... 포함)
//				: ${어트리뷰트명}

//		어트리뷰트값 읽기(객체)
//				주소값 - ${어트리뷰트명}
//				속성값 - ${어트리뷰트명.멤버변수명}

//		어트리뷰트값 읽기(List, [])
//				AL / [] 자체 			- ${ 어트리뷰트명 }
//				인덱스 위치의 객체		- ${어트리뷰트명[인덱스]}
//				인덱스 위치의 객체 속성 - ${어트리뷰트명[인덱스].멤버변수명 }
//		반복문, 조건문 - EL (X) 불가능 하다. / CustomTag (o)

%>
<%
//getParameter("x")는  form tag나 ?A=asdfasdf 이런 형식일 때 사용
//getAttribute("x")는 setAttribute로 보낼 때 사용

	String x = request.getParameter("x");
	String y = request.getParameter("y");
	double z = (Double) request.getAttribute("z");
	
	Polarbear pb = (Polarbear) request.getAttribute("b");
	ArrayList<Polarbear> pbvs = (ArrayList<Polarbear>) request.getAttribute("pbvs");
%> 

<h1>결과</h1>
${param.x} <p>
${param.y} <p>
${param.x * param.y} <p>

${z} <p>
${b.name} <p>
${b.age} <p>
${b.height} <p>
${b.weight} <p>
<hr>
<!-- 무시하고 넘어간다 빈 값이므로 -->
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