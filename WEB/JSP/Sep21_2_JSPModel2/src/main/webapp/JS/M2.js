//Model
//		front-end ������B (��ȿ�� �˻� ������ front-end ������A�� �������)
function check(){
	let x = document.f.x;
	let y = document.f.y;
	
	if(isEmpty(x) || isNotNumber(x) ||
	isEmpty(x) || isNotNumber(x)){
		alert("���� �ٽ� �Է��ϼ���");
		return false;
	}
	return true;
}

