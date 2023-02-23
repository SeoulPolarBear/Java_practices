<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Internationalization</title>
</head>
<body>
	<fmt:setLocale value='<%= request.getParameter("language") %>' />
	<fmt:setBundle basename="ch09.com.bundle.myBundle01" var="resourceBundle" />
		<div class="text-left">
			<a href="?language=ko" >Korean</a>|<a href="?language=en" >English</a>
		</div>
		<p><fmt:message key="id" bundle="${resourceBundle }"/> : <input type="text" name="id" />
		<p><fmt:message key="password" bundle="${resourceBundle }"/> : <input type="text" name="password" />
		<p><input type="submit" value="<fmt:message key="button" bundle="${resourceBundle }"/>">
</body>
</html> 