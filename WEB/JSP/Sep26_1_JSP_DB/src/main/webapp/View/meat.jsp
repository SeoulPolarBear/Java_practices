<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>meat</title>

<link rel="stylesheet" href="CSS/meat.css">
</head>
<body>

	<table id="total" style="background-color: orange;" border="1">
		<tr>
			<td align="right" colspan="2">${result}</td>
			<td align="right" colspan="2"><a style="text-decoration: none"
				href="enrollController">등록</a></td>

		</tr>

		<tr>
			<th>고유ID</th>
			<th>부위</th>
			<th>종류</th>
			<th>가격</th>
		</tr>

		<c:forEach var="meat" items="${meats}">
		
			<tr id ="instance" onclick="goMeatDetail(`${meat.m_id}`)">
				<td>${meat.m_id}</td>
				<td>${meat.m_kind}</td>
				<td>${meat.m_from}</td>
				<td><fmt:formatNumber value="${meat.m_price}" type="number" />
				</td>
			</tr>
		</c:forEach>
<tr>
 <td align = "center" colspan = "4">
 <c:forEach var="p" begin = "1" end = "${pageCount}">
 <a href="MeatPageController?pageCount=${p}">${p}</a>
 </c:forEach>
 </td>
</tr>


	</table>

</body>
</html>