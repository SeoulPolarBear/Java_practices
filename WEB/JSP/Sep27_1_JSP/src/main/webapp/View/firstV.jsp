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
//����ڰ� ��� �׼��� ���� �� �̵� : ��û
//		- <a href="~~controller?parameter=~~"> : Ŭ���ϸ� GET ���
//		- JS�� �Ἥ location.href="~~controller?parameter=" + ~: � �̺�Ʈ�� ����ؼ� �߰� ���� �� GET���
//			(JS�� HTML����°� ���� -> JS�� <form>�� ����� POST��ĵ� ���� O)
//		-<form> + <button> : ��ư�� Ŭ������ �� GET/POST���
%>
<h1>First</h1>
d : ${sessionScope.d }<br>
e : ${cookie.e.value } <br>

<a href="SecondC?a=10&b=100">SecondC��</a>
<hr>
<div onclick="gogogo();">SecondC��</div>

<form action="SecondC">
a: <input name ="a"> <br>
b: <input name ="b"> <br>
<button>SecondC��</button>
</form>
</body>
</html>