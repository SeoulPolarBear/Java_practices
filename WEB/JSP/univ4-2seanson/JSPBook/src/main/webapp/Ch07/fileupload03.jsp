<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>file Upload</title>
</head>
<body>
	<form method = "post" enctype = "multipart/form-data"
	action = "fileupload03_process.jsp">
	<p>파일 : <input type = "file" name ="filename">
	<p><input type = "submit" value ="파일올리기">
	</form>
</body>
</html>