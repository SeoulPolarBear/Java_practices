<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Directive Tag</title>
</head>
<body>
	<c:forEach var="k" begin = "1" end = "10" step = "1">
	<c:out value = "${k}" />
	</c:forEach>
</body>
</html>