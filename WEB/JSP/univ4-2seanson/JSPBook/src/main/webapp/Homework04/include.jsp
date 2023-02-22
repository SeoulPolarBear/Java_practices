<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Tag</title>
</head>
<body>
	<h4>구구단 출력하기</h4>
	<jsp:include page="forward_data.jsp" flush="false">
	<jsp:param name="five" value="5" />
	</jsp:include>
</body>
</html>