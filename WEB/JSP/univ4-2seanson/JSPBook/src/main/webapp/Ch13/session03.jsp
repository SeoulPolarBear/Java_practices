<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<title>Session</title>
</head>
<body>
	<%
		String name;
		String value;
		
		Enumeration en = session.getAttributeNames();
		int i = 0;
		
		while(en.hasMoreElements()){
			i++;
			name = en.nextElement().toString();
			value = session.getAttribute(name).toString();
			
			out.println("설정된 세션의 속성명 [" + i + " ] : " + name + "<br>");
			out.println("설정된 세션의 속성값 [" + i + " ] : " + value + "<br>");
		}
	%>
</body>
</html>