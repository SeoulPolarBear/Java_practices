// �߸������� true��(���� ������ �Ǹ� true, �������̸� false�� ����)

// <input>�� �־��� ��
// �ƹ��͵� �Ƚ����� true, ���� ������ false
function isEmpty(input){
	return (!input.value);
}

// <input>�� �־��� ��
// �ѱ� / Ư�����ڰ� �����ִٸ� true, ���ٸ� false
function containsAnother(input){
	let pass = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@_.^";
	
	let iv = input.value;
	for(let i = 0; i < iv.length; i++){
		if(pass.indexOf(iv[i]) == -1){//pass�� �ִ� ���� �߿���
										//���� ���� ������ true
		return true;			
		}
	}
	return false;
}

//<input>, ���� ���� �־��� ��
//�� ���ڼ����� ������ true, �� ���ڼ� �̻��̸� false
function atLeastLetter(input, len){
	return (input.value.length < len);
}

//<input> x 2 �־��� �� (pw, pwȮ��)
//������ �ٸ��� true, ������ false
function notEqualPw(input, input2){
	return (input.value !== input.value);
}

//<input>, ���ڿ���Ʈ �־��� ��
// ������ true, ������ false (�Է��� pw�� ������ ���ڿ��� ���� ���)
function notCotain(input, passSet){
	let iv = input.value;
	for(let i = 0; i < passSet.length; i++){
		if(iv.indexOf(passSet[i]) != -1){
			return false;
		}
	}
	return true;
}

//<input> �־��� �� ���ڸ� �Է��� �ؾ� �� ��
// ���� �ƴѰ� ������ true, ���ڸ� ������ false
function isNotNumber(input){
	return isNaN(input.value);
}

//<input>, Ȯ���� �־��� ��
// Ȯ���ڸ��� �ƴϸ� true, ������ false
//type : array
function isNotType(input, type){
	//.gif, .png, ...
	for(let i = 0; i < type.length; i++){
		type[i] = "." + type[i];
		//���Ŀ� �´°� �ϳ��� ������ false�� �༭ ���������� �˷��ش�.
		if(input.value.indexOf(type[i]) != -1){
			return false;
		}
	}
	
	return true;
}


























