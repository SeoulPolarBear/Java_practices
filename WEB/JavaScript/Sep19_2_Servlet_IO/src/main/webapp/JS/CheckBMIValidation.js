function validData(){
	let myName = document.ff.myName;
	let myHeight = document.ff.myHeight;
	let myWeight = document.ff.myWeight;
	let myPhoto = document.ff.myPhoto;
	
	let Validation = true;
	//�̸�
	if(isEmpty(myName) || containsAnother(myName)) {
		alert("�̸��� ����ְų� ��� �ƴ� ���𰡰� �ֽ��ϴ�.");
	Validation = false;
	}
	//Ű
	if(isEmpty(myHeight) || isNotNumber(myHeight)) {
		alert("Ű�� ����ְų� ���ڸ� �Է°����մϴ�.");
		Validation = false;
		}
	//������
	if(isEmpty(myWeight) || isNotNumber(myWeight)) {
		alert("�����԰� ����ְų� ���ڸ� �Է°����մϴ�.");
		Validation = false;
		}
	//����
	let type = ["PNG","JPG","png","jpg"];
	if(isEmpty(myPhoto) || isNotType( myPhoto, type )) {
		alert("photo�� ����ְų� ���� ����� �߸� �Ǿ����ϴ�.");
		Validation = false;
		}
	return Validation;
}


