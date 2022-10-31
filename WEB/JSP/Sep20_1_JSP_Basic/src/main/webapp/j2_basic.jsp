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
	let num2 = prompt("숫자를 입력하세요.");
	if (num2 % 2 == 0) {
		document.write("<h1>");
		document.write(num2);
		document.write("는 짝수 입니다.</h1>");
	} else {
		document.write("<h1>");
		document.write(num2);
		document.write("는 홀수 입니다.</h1>");
	}
	}
}
</script>
</head>
<body>
	<%--
		랜덤한 숫자를 넣었을 때, 짝인지 홀인지 알려주는 기능
		뽑은 숫자와 홀짝 여부를 웹페이지에 출력
	 --%>
	<%!
	public String getOE(int x){
		return x%2 == 0? "짝수": "홀수";
	}
	%>
	
	<%
	Random rand = new Random();
	int num = rand.nextInt(100) + 1;
	String result = getOE(num);
	%>
	<button onclick="check();">버튼</button>
	<marquee>
		숫자 :
		<%=num%>
		<br>결과 :
		<%=result%>
	</marquee>

</body>
</html>