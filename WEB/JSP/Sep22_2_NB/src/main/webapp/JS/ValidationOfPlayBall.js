/**
 * !nonDuplication(usernum) && !NumLen(usernum) &&
 */
 function validation(){
	let usernum = document.playball.userNum;
	if(nonDuplication(usernum) && 
	NumLen(usernum) && 
	!isNotNumber(usernum)){
	return true;	
	}
	else {
		alert("숫자가 아닌거나 3자리가 아니거나 중복되는 숫자가 존재합니다.");
		return false;
	}
}