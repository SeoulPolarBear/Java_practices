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
<!-- 	First.jsp���� �� ���ڸ� �Է� ���� ��
	Second.jsp���� �� ���� ������ִ� ��� -->
	
	<h1>First</h1>
	<hr>
	<a href = "Second.jsp?x=10&y=20">&lt;a&gt;�� [GET ��� ��û]</a>
	<div onclick="gogo();">JavaScript�� [GET��� ��û]</div>
	
	
	
	<form action="Second.jsp" onsubmit = "return check();">
		X: <input type = "text" name = "x"><p>
		Y: <input type = "text" name = "y"><p>
		<button>form + button �������� [GET / POST ��� ��û]</button>
	</form>
</body>
</html>