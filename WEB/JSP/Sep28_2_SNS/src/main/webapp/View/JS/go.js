function logout(){
	let really = confirm("�α׾ƿ� �Ͻðڽ��ϱ�");
	if(really){
		location.href = "loginController?contentPage=logout.jsp";
	}	
}
function SignUp(){
	let really = confirm("ȸ�� �����Ͻðڽ��ϱ�?");
	if(really){
		location.href = "SignUpController";
	}	
}

function info(){
	let really = confirm("������ �����ϰڽ��ϱ�?");
	if(really){
		location.href = "UpdateController";
	}	
}