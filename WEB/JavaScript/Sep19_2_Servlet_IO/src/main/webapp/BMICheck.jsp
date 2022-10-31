<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����</title>
<link rel = "stylesheet" href="./CSS/jsp_css.css">
</head>
<body>
	<%
	request.setCharacterEncoding("EUC-KR");
	String path = request.getServletContext().getRealPath("img");
	MultipartRequest mr = new MultipartRequest(request, path, 1024 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
	String myName = mr.getParameter("myName");
	String myHeight = mr.getParameter("myHeight");
	String myWeight = mr.getParameter("myWeight");
	String img = mr.getFilesystemName("myPhoto");

	//������ / Ű * Ű (m  ����)
	double weight = Double.parseDouble(myWeight);
	double height = Double.parseDouble(myHeight) / 100;

	double BMI = weight / Math.pow(height, 2);
	String result = "";
	if (BMI >= 25.00) {
		result = "��";
	} else if (BMI >= 23.00) {
		result = "��ü��";
	} else if (BMI >= 18.5) {
		result = "����";
	} else if (BMI >= 0) {
		result = "��ü��";
	} else {
		result = "?? �̻��ѵ�";
	}
	String bmi2 = String.format("%.2f", BMI);

	img = URLEncoder.encode(img, "EUC-KR");
	img.replace("+", " ");
	%>
	<table id ="table-total">
		<tr>
			<th id="title" colspan = "2">BMI �˻�</th>
		</tr>
		<tr>
			<td class="category">�̸� :</td>
			<td class="contents"><h1><%=myName%></h1>
				<br></td>
		</tr>
		<tr>
			<td class="category" >Ű :</td>
			<td class="contents"><h1><%=myHeight%></h1>
				<br></td>
		</tr>
		<tr>
			<td class="category">������ :</td>
			<td class="contents"><h1><%=myWeight%></h1>
				<br></td>
		</tr>
		<tr>
			<td class="category">����</td>
			<td class="contents"><img class = "photos" src="img/<%=img%>"><br></td>
		</tr>
		<tr>
			<td class="category">BMI</td>
			<td class="contents"><marquee id = "result">
					BMI :<%=bmi2%>����
					<%=result%>
					�Դϴ�.
				</marquee>
				<br></td>
		</tr>
	</table>





</body>
</html>