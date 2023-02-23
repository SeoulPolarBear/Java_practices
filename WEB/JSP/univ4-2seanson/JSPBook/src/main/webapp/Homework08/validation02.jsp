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
	    
	    
	    
	    if(/(\w)\1\1/.test(passwd))
        {
        alert("영문,숫자는 3자 이상 연속 입력할 수 없습니다.");
        form.passwd.focus();
        return false;
        }
    form.submit();
}
	
	    /*for(i = 0; i<form.passwd.value.length; i++){
	    	var ch[i] = passwd.charAt(i);
	    	int num[i] = (Integer)ch[i];
	    }
	    var regExp = /^[a-z|A-Z]/;
	    for(i = 0; i<form.passwd.value.length; i++){
	    	if((regExp.test(ch[i]))&&(regExp.test(ch[i+1]))&&(regExp.test(ch[i+2]))){
	    		alert("영문,숫자는 3자 이상 연속 입력할 수 없습니다.");
	    	}
	    	if((0<=num[i]&&num[i]<=9)&&(0<=num[i+1]&&num[i+1]<=9)&&(0<=num[i+2]&&num[i+2]<=9)){
	    		alert("영문,숫자는 3자 이상 연속 입력할 수 없습니다.");
	    	}
	    }*/
	    
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