/**
 * 
 */
 
 //4. �� ��ȯ
 // String() -> ���������� ��ȯ
 //Number() -> ���������� ��ȯ
 //Boolean() -> �������� ��ȯ
 
 //�� ��ȯ�� �� �ʿ��ұ�� ~ ?
 //	�ڷ����� �ٸ� �� ������ ������� ��, ���ϴ� ����� ������ ���� �� ����...
 // ����, ���������� �Է� �޾Ƽ� ��� ������ ������ִ� ���α׷�
 // ��� (document.write)
 
let math  = prompt("���� ������ �Է��ϼ���.")
let English  = prompt("���� ������ �Է��ϼ���.")
//�ڵ��� ��ȯ
// "80" + "90" = "8090"
//�������� �ƴϴ��� ǥ����(+,-,*,/)�� Ȱ������ �� ���������� ��ȯ�� �� �ִٸ�
//�ڵ����� �� ��ȯ�� �Ǿ ����� ��
//'�ڵ� �� ��ȯ'�̶�� ��

//�ڵ� ����ȯ�� ���ƺ�������
//������ ã�� ���� ������ �߻���ų ������ ����� ����...
//	=> �׻� �ǵ��� ������ ���ϴ� Ÿ��(�ڷ���)���� ��ȯ�ؼ� ����ϴ� ���� ����.
//		'����� �� ��ȯ'
let sum = math + English;
let avg = sum / 2;
 document.write(avg + "<br>");
 document.write(math + "<br>");
 document.write(English + "<br>");
 
 
 document.write("String() <br>");
 document.write(
	String(3) + "<br>",
	String(true) + "<br>",
	String(false) + "<br>",
	String(null) + "<br>",
	String(undefined) + "<br>"
);

//Number() : N�� �빮�� ! / ��ȣ���� ���� ���������� �ٲ���
document.write("Number() <br>");
document.write(
	Number("1234") + "<br>",
	Number("asdfa") + "<br>",
	String(true) + "<br>",
	String(false) + "<br>",
	String(undefined) + "<br>"
);
 
 //Boolean() : B�� �빮�� / ��ȣ���� ���� �������� �ٲ���
 //false�� �˾Ƶθ�...
 //	-���� 0
 //	-�� ���ڿ�("")	/	���� X
 //	-null
 //	-undefined
 //	-NaN
 //�̿ܿ��� ��� true�� ��!
 
 //���ǻ��� -> ���� ������ ���... �����صνô°� ���ھ��...
Number(null);//	0
Number(undefined);//	NaN


let a = Number(prompt("asdf"));
document.write(a + "<br>");//Ȯ��(""), ���(null) ��� 0 
 
 
 
 
 
 
 
 
 
 
 
 
 
 