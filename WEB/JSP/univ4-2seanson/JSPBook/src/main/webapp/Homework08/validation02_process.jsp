<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Validation</title>
</head>
<body>
 <%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	%>
	
	<p> 아이디 : <%=id%>
	<p> 비밀번호 : <%=passwd%>
</body>
</html>
