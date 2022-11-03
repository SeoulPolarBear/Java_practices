<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function gogogo(){
	location.href="SecondC?a=20&b=200";
}
</script>
</head>
<body>
<%
//사용자가 어떠한 액션을 했을 때 이동 : 요청
//		- <a href="~~controller?parameter=~~"> : 클릭하면 GET 방식
//		- JS를 써서 location.href="~~controller?parameter=" + ~: 어떤 이벤트를 사용해서 추가 했을 때 GET방식
//			(JS로 HTML만드는게 가능 -> JS로 <form>을 만들면 POST방식도 가능 O)
//		-<form> + <button> : 버튼을 클릭했을 때 GET/POST방식
%>
<h1>First</h1>
d : ${sessionScope.d }<br>
e : ${cookie.e.value } <br>

<a href="SecondC?a=10&b=100">SecondC로</a>
<hr>
<div onclick="gogogo();">SecondC로</div>

<form action="SecondC">
a: <input name ="a"> <br>
b: <input name ="b"> <br>
<button>SecondC로</button>
</form>
</body>
</html>