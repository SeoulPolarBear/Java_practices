<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	let num2 = prompt("���ڸ� �Է��ϼ���.");
	if (num2 % 2 == 0) {
		document.write("<h1>");
		document.write(num2);
		document.write("�� ¦�� �Դϴ�.</h1>");
	} else {
		document.write("<h1>");
		document.write(num2);
		document.write("�� Ȧ�� �Դϴ�.</h1>");
	}
	}
}
</script>
</head>
<body>
	<%--
		������ ���ڸ� �־��� ��, ¦���� Ȧ���� �˷��ִ� ���
		���� ���ڿ� Ȧ¦ ���θ� ���������� ���
	 --%>
	<%!
	public String getOE(int x){
		return x%2 == 0? "¦��": "Ȧ��";
	}
	%>
	
	<%
	Random rand = new Random();
	int num = rand.nextInt(100) + 1;
	String result = getOE(num);
	%>
	<button onclick="check();">��ư</button>
	<marquee>
		���� :
		<%=num%>
		<br>��� :
		<%=result%>
	</marquee>

</body>
</html>