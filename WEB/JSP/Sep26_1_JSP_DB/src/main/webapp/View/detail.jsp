<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������</title>
</head>
<body>
<h2>Meat Information</h2>
<form action="MeatDetailController" method="post">
	<!-- readonly="readonly" ������ ���� �ʰ� ���ش�. -->
	������ȣ : <input readonly="readonly" autocomplete="off" autofocus="autofocus"
			name="m_id" class="inputt" value="${meatmeat.m_id}" ><p>
	���� : <input autocomplete="off" autofocus="autofocus"
			name="m_kind" class="inputt" value="${meatmeat.m_kind}"><p>
	���� : <input autocomplete="off" autofocus="autofocus"
			name="m_from" class="inputt" value="${meatmeat.m_from}"><p>
	���� : <input autocomplete="off" autofocus="autofocus"
			name="m_price" class="inputt" value="${meatmeat.m_price}"><p>
	���� : <textarea id="textarea"  autocomplete="off" maxlength="80" rows="10" cols="20"
			name="m_introduce" class="inputt"> ${meatmeat.m_introduce}</textarea> <p>
			<!-- ��� -> � �帧 -> � ȭ�� -->
			<p>
			<button id = "btn" name="updates" value="update">����</button>
			
</form>
<p>
<button id = "btn" onclick="deleteMeatDetail(${meatmeat.m_id})">����</button>
</body>
</html>