//Model
//		front-end 개발자B (유효성 검사 보물도 front-end 개발자A가 만들었음)
function check(){
	let x = document.f.x;
	let y = document.f.y;
	
	if(isEmpty(x) || isNotNumber(x) ||
	isEmpty(x) || isNotNumber(x)){
		alert("숫자 다시 입력하세요");
		return false;
	}
	return true;
}

