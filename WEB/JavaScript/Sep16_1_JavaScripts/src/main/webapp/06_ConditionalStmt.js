/**
 * 
 */
//��������, �񱳿�����, ��ġ������ ��������� ���� true, false�� ������
//6. ���ǹ�
//		� ���ǿ� ���� ���Ŀ� ������ �޶����� �ϴ�...

//if��(Java�� ����.)
//	if�� ��ȣ�ȿ� ������ ������ true��� �����ϰԲ�!
//	if - else if - else 

// switch-case
// case�� �پ��� ��, ���� �����ϰ� ��Ÿ�� �� �ִ�.��� ������ �ִ�.
let fruit = prompt("������ �Է��ϼ���");

switch(fruit){
	case "���":
	alert("100��");
	break;

	case "�ٳ���":
	alert("200��");
	break;

	case "Ű��":
	alert("300��");
	break;

	case "���":
	case "����":
	alert("500��");
	break;
}