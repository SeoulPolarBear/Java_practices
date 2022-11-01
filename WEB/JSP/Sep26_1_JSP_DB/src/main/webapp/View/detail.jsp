<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상세정보</title>
</head>
<body>
<h2>Meat Information</h2>
<form action="MeatDetailController" method="post">
	<!-- readonly="readonly" 변경이 되지 않게 해준다. -->
	고유번호 : <input readonly="readonly" autocomplete="off" autofocus="autofocus"
			name="m_id" class="inputt" value="${meatmeat.m_id}" ><p>
	부위 : <input autocomplete="off" autofocus="autofocus"
			name="m_kind" class="inputt" value="${meatmeat.m_kind}"><p>
	종류 : <input autocomplete="off" autofocus="autofocus"
			name="m_from" class="inputt" value="${meatmeat.m_from}"><p>
	가격 : <input autocomplete="off" autofocus="autofocus"
			name="m_price" class="inputt" value="${meatmeat.m_price}"><p>
	설명 : <textarea id="textarea"  autocomplete="off" maxlength="80" rows="10" cols="20"
			name="m_introduce" class="inputt"> ${meatmeat.m_introduce}</textarea> <p>
			<!-- 기능 -> 어떤 흐름 -> 어떤 화면 -->
			<p>
			<button id = "btn" name="updates" value="update">수정</button>
			
</form>
<p>
<button id = "btn" onclick="deleteMeatDetail(${meatmeat.m_id})">삭제</button>
</body>
</html>