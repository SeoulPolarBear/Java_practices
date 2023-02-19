<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import ="org.apache.commons.fileupload.*" %>
<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>File Upload</title>
</head>
<body>
	<%
	String fileUploadPath = "C:\\upload";
	DiskFileUpload upload = new DiskFileUpload();
	List items = upload.parseRequest(request);
	Iterator params = items.iterator();
	
	while(params.hasNext()){
		FileItem fileItem = (FileItem) params.next();
		if(!fileItem.isFormField()){
			String fileName = fileItem.getName();
			System.out.println(fileName + "...." + fileName.lastIndexOf("\\"));//실습
			
			
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			File file = new File(fileUploadPath + "/" + fileName);
			fileItem.write(file);
		}
	}
	%>
</body>
</html>