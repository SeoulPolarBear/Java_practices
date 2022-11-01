/**
 * 
 */
 function validation(){
	let num1 = document.f.num1;
	let num2 = document.f.num2;
	
	if(isEmpty(num1) || isEmpty(num2)){
		alert("숫자 비었음");
		num1.focus();
		return false;
	}
	if(isNotNumber(num1) || isNotNumber(num2)){
		alert("숫자 아닌거 있음");
		num1.value="";
		num2.value="";
		num1.focus();
		return false;
	}
	return true;
}