import java.util.Scanner;

public class CMain4 {
	
	//switch-case (ex : ���� ����)
	public static void main(String[] args) {
		//Scanner�� �Է��� ���� ��!
		Scanner scanner = new Scanner(System.in);
		System.out.println("����� ����? : ");
		String army = scanner.next();
		
		String a  = "��ġ";
		String b = "�����";
		String c = "�Ʒ�";
		String d = "��";
		
		//�̺� �Է� -> ��ġ, �����, �Ʒ�, ��
		//�Ϻ� �Է� -> �����, �Ʒ�, ��
		//�� �Է� -> �Ʒ�, ��
		//���� �Է� -> ��
		switch (army) {
		case "�̺�":
			System.out.println(a);
			
		case "�Ϻ�":
			System.out.println(b);
			
		case "��":
			System.out.println(c);
			
		case "����":
			System.out.println(d);
			break;

		default:
			System.out.println("�� �Ҹ��� ���� �����ε�");
			break;
		}
		
	}
}
