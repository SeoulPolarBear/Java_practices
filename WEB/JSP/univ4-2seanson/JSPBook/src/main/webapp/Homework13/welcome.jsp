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
	String userID = (String)session.getAttribute("userID");
if(userID==null){
	response.sendRedirect("session_out.jsp");
		}
	out.println(userID + "�� �ݰ����ϴ�");
%>
<p><a href = "session_out.jsp">�α׾ƿ�</a>
</body>
</html>