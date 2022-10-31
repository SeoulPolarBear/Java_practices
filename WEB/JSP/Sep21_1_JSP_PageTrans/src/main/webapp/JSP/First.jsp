<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function gogo(){
	location.href = "Second.jsp?x=100&y=200";
}

</script>
</head>
<body>
<!-- 	First.jsp에서 두 숫자를 입력 했을 때
	Second.jsp에서 그 합을 출력해주는 기능 -->
	
	<h1>First</h1>
	<hr>
	<a href = "Second.jsp?x=10&y=20">&lt;a&gt;로 [GET 방식 요청]</a>
	<div onclick="gogo();">JavaScript로 [GET방식 요청]</div>
	
	
	
	<form action="Second.jsp" onsubmit = "return check();">
		X: <input type = "text" name = "x"><p>
		Y: <input type = "text" name = "y"><p>
		<button>form + button 조합으로 [GET / POST 방식 요청]</button>
	</form>
</body>
</html>