/**
 * 
 */
 //중복확인
 function nonDuplication(input){
	let val = input.value;
	//012~987에서만 가능
	if(val[0] === val[1]
	|| val[1] === val[2]
	|| val[2] === val[0]){
		alert("중복 숫자가 존재합니다.");
		return false;
	}else{
		return true;
	}
}

//무조건 3자리 숫자여야함
function NumLen(input){
	if(input.value.length !== 3){
		alert("3자리 숫자여야합니다.");
		return false;
	}
	else{ 
	return true;
	}
}

