<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type = "text/javascript">
	function checkLogin(){
		var form = document.loginForm;
		
		var passwd=form.passwd.value;
	    var passwd2=form.passwd02.value;
		
	    if(passwd != passwd2)
        {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
        }
	    
	    var regExpPasswd=/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,}$/;
	    if(!regExpPasswd.test(passwd))
        {
        alert("영문+숫자+특수기호 8자리 이상으로 구성하여야 합니다.");
        return false;
        }
    form.submit();
}
	
</script>


<title>Validation</title>
</head>
<body>
	<form name = "loginForm" action = "validation02_process.jsp">
	<p>아이디 : <input type = "text" name = "id">
	<p>비밀번호 : <input type = "password" name = "passwd">
	<p>비밀번호 확인 : <input type = "password" name = "passwd02">
	<p><input type = "button" value = "전송" onclick = "checkLogin()">
	</form>
</body>
</html>