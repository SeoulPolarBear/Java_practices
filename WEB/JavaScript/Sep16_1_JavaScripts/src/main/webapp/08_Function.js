/**
 * 
 */
//8.�Լ�(Function)
// ���񽺸� ����ٺ��� ���ų�, ����� ����� ����� ����...
//		�˾�â, ����,...
// �Ź� ���Ӱ� ������ ����! => ���� ����ϴ� ��ɵ��� �ϳ��� ��� �ҷ��پ���!

//function �Լ���(�Ķ����){
	//����
//}
// �� �����̰�, �Լ���(�Ķ����); �� ȣ���ϸ� ��

// �Ķ���� ���� �Լ�
/*function showError(){
	alert("���� �߻� !!!!!");
}
showError();*/
//�� �޽����� �ϳ��� ���� �� ������������ ���� �ִٰ� �����غ���...
// ex) �α��� ����, ���� ����, ...
// ���� showError(); �� �ҷ��� ���� �ǰڳ׿�!

//�Ķ���� �ִ� �Լ�
/*function sayHello(name){
	let msg = `Hello`;
	if(name){
		msg += `,${name}`;
	}
		alert(msg);
	
}
sayHello();*/
//���� argument ���� ������ undefined�� ���.

let msg = "Hello"; // ��𼭳� ������ �� �ִ� ���� : ���� ����(Global Variable)
console.log("�Լ� ȣ�� ��");
console.log(msg);

function sayHello(name){
	let msg = `Hello`;
	if(name){
		msg += `,${name}`;
	}
	// �Լ� ���ο��� ������ �� �ִ� ���� : ��������(Local Variable)
	console.log(msg);
		alert(msg);
}
sayHello("polarbear");
console.log("�Լ� ȣ�� ��");
console.log(msg);
//���������� �Լ� ������ ���������� ���� �̸����� ���� �� �ְ�,
// ���� ������ ���� ����

//���������� �������� �����ϱ� ����� ������...
//		=> �����ϸ� �Լ��� Ưȭ�Ǿ��ִ� ���������� �������!

//OR�� Ȱ���ؼ� �⺻�� �ֱ�
function sayHello2(name){
	let newName = name || 'Friend';
	let msg = `Hello, ${newName}`;
	console.log(msg);
}
sayHello2();// ���� ���� ������
sayHello2("polarbear");// ���� ������

//�⺻���� �����ؼ� (default value)
function sayHello3(name = 'Friend'){
	let msg = `Hello, ${name}`;
	console.log(msg);
}
sayHello3();
sayHello3("polar");

// return���� �� ��ȯ�ϱ�
function add(num1, num2){
	return num1 + num2;
}
let result = add(2,3);
console.log(result);
//return�� ��ȯ�ϴ� �Ͱ� ���ÿ� �Լ��� �����ϴ� ��ɵ� ����!

//����
// - �Լ��� �ѹ��� �� �۾��� �ϴ°� ����.
//		-> �ϳ��� �Լ��� ���� �۾��� ���� �Ѵٸ�, ������ �Լ��� �����ϱ�
//	- �Լ����� �б� ����, � ������� �� �� �ְ� ���̹�!!
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 