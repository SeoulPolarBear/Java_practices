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
	//		값 받기 : EL ${}
	
	// 페이지 이동
	//	redirect, forward, include
	
	// 조건문, 반복문
	// 출력형식 (소수점, 날짜 형식, ...)
	
	// CustomTag
	//		생김새는 HTML DOM객체
	//		.JSP -> servlet으로 바뀔 때 java로 변환!
	//			=> .JSP에서만 사용 가능 O
	//		<접두어: 태그명>
	//			<xxx:table></xxx:table>		=> 열고 닫기 한 쌍으로!
	//			<xxx:table />				=> 열고 닫기 사이에 내용이 없으면
	
	//	JSP표준액션태그
	//		JSP환경에서 기본적으로 사용 가능
	//		그 접두어가 jsp
	//		forward, include, ...
	//	커스텀태그
	//		외부 .jar를 넣고 사용을 함(jstl)
	//		접두어가 마음대로...
	//		반복문, 조건문, 출력형식, ...
%>
<h1>First</h1>
<!-- second.jsp의 소스가 아래에 -->
<!-- *** 원하는 자리에 넣어서 표현할 수 있다는게 장점 -->
<jsp:include page="second.jsp"></jsp:include>


<h2>Third</h2>
























</body>
</html>