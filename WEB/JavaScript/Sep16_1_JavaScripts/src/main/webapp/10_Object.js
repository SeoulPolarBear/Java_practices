/**
 * 
 */
 
 //10. ��ü(Object)
 
 //���� Ű��� �������� '����', 3��
 let dog = {
	name: "����",
	age: 3
}

//��ü�� �߰�ȣ �ȿ��� �����Ǹ�, key�� value������ ������ ������Ƽ(�Ӽ�)�� ��

//���� ��ǥ�� �����ϰ�, ���������� ��ǥ�� ��� ������...!
// ���߿� �̰����� ������ ���� �����ϸ� ��ǥ ������� �͵� ������

//����
console.log(dog.name);
console.log(dog['age']);

//�Ӽ� �߰�
dog.gender = "Male";
dog["furColor"] = "White";

//����
delete dog.furColor;


// ���� ������Ƽ

let name = "polarbear";
let age = 5;

let person = {
	name: name,
	age: age,
	gender: "Male",
}// �̷��� ǥ���� �� �ִµ�... �� ���¸� �� �� ���̸�...

let  person3 = {
	name,
	age,
	gender:"Male",
}
//�̷� ���·� ǥ�� ����(�� ��, key ���� value���� �޾ƿ� ������ �̸��� ���ƾ� �Ѵ�.)
// �������� �ʴ� �Ӽ��� �����ϸ�, ������ �߻��ϴ°� �ƴ� undefined ���� ���´�.
//�� �� 'in' �����ڸ� ����ϸ� ���� ã�� �Ӽ��� �ִ��� Ȯ���� �� ����
// in : � ���� �ִ��� Ȯ���ϱ� ���ؼ� ���
console.log('birthday' in person);
console.log('age' in person);

// �Լ��� ��ü �����
function makeObject(name, age){
	return{
	name,
	age,
	hobby:"Game",
	}
}

let person2 = makeObject("polarbear", 31);
console.log(person2);







