function logout(){
	let really = confirm("로그아웃 하시겠습니까");
	if(really){
		location.href = "loginController?contentPage=logout.jsp";
	}	
}
function SignUp(){
	let really = confirm("회원 가입하시겠습니까?");
	if(really){
		location.href = "SignUpController";
	}	
}

function info(){
	let really = confirm("정보를 수정하겠습니까?");
	if(really){
		location.href = "UpdateController";
	}	
}