/**
 * 
 */
 //�ߺ�Ȯ��
 function nonDuplication(input){
	let val = input.value;
	//012~987������ ����
	if(val[0] === val[1]
	|| val[1] === val[2]
	|| val[2] === val[0]){
		alert("�ߺ� ���ڰ� �����մϴ�.");
		return false;
	}else{
		return true;
	}
}

//������ 3�ڸ� ���ڿ�����
function NumLen(input){
	if(input.value.length !== 3){
		alert("3�ڸ� ���ڿ����մϴ�.");
		return false;
	}
	else{ 
	return true;
	}
}

