<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <!-- core�� �־�� fmt�� �� �� �ִ�. (x) -->
    <!-- core / fmt ���� ���� ����̶� ������ �� �� ������ �� -->
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>fmt</title>
</head>
<body>
<!-- fmt: ���ڿ� / ��¥ ���� ������ -->


<!-- ���ڰ��� format -->
<fmt:formatNumber value = "${a }" type="number"/><p>
<!-- 123,456,789 -->

<!-- ��ȭ���� format -->
<fmt:formatNumber value = "${a }" type="currency" currencySymbol="$"/><p>
<!-- $123,456,789 -->

<!-- ���ڰ��� format (�Ҽ����� �ݿø� ���ش�.)-->
<fmt:formatNumber value = "${b }" type="percent"/><p>

<fmt:formatNumber value = "${c }" pattern="#.00"/><p>

<hr>

<!-- Date �Ӽ�
		: type = "date / time / both"
		1. date 
			dateStyle = "short / long"
		2. time
			timeStyle "short / long"
		3. both
			dateStyle = "short / long"
			timeStyle "short / long"
 -->

<fmt:formatDate value="${d}" type ="both" dateStyle="long" timeStyle="short"/> <br>

<!-- ���� -->

<fmt:formatDate value="${d}"  pattern="yyyy-MM-dd E a hh"/><br>














</body>
</html>