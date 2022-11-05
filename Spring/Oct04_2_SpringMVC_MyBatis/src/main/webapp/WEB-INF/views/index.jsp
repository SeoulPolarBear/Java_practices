<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<form action="student.req">
		이름 : <input autofocus="autofocus" type="text" name="s_name">
		<p>
			별명 : <input type="text" name="s_nickname">
		<p>
			<button>등록</button>
	</form>
	<hr>
	${r }
	<c:forEach var="s" items="${students}">
	${s.s_name} - ${s.s_nickname}
	</c:forEach>
	<hr>
	<form action="test.req">
		시험 과목명 : <input type="text" name="t_subject">
		<p>
			시험날짜 : <select name="t_y">
				<c:forEach var="y" begin="2022" end="2032">
					<option value="${y}">${y}</option>
				</c:forEach>
			</select> - <select name="t_m">
				<c:forEach var="m" begin="1" end="12">
					<option value="${m}">${m}</option>
				</c:forEach>
			</select> - <select name="t_d">
				<c:forEach var="d" begin="1" end="31">
					<option value="${d}">${d}</option>
				</c:forEach>
			</select>
		<p>
			시험학생번호 :<input type="text" name="t_s_no">
		<p>
			<button>등록</button>
	</form>

<hr>
<c:forEach var = "t" items="${tests}">
${t.t_subject}
-
<fmt:formatDate value="${t.t_date}" type="date" dateStyle="long"/> 
-${t.t_s_no}<p>
</c:forEach>
</body>
</html>