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
		alert("���ڰ� �ƴѰų� 3�ڸ��� �ƴϰų� �ߺ��Ǵ� ���ڰ� �����մϴ�.");
		return false;
	}
}