import java.util.Scanner;

public class CMain3 {

	public static void main(String[] args) {
		//���� �ϳ� �Է� ���� �� �ְ�
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �ϳ� �Է��ض� : ");
		int x = scanner.nextInt();
		
		//���ǹ� : if, switch ~ case
		
		
		//switch �� : �� ������ Ư���� ���̳� ���ڿ��� ��� ���
		//break;�� �̿��ؼ� �� ������ �����ϸ� switch���� �������� �� �� �ִ�.
		/*
		 * switch (���� or ��) { 
		 * case �� A: 
		 * ���� or ���� ���� A�� �� �� �κ��� ���� 
		 * break;
		 * 
		 * case �� B: 
		 * ���� or ���� ���� B�� �� �� �κ��� ���� 
		 * break;
		 * 
		 * default: 
		 * A or B�� �ƴ� �� �� �κ��� ������ �ȴ�.
		 * break; 
		 * }
		 */
		
		switch (x) {
		case 1:
			System.out.println("��");
			break;
			
		case 2:
			System.out.println("��");
			break;
			
		case 3:
			System.out.println("�Ф�");
			break;

		default:
			System.out.println("����...");
			break;
		}
	}
}
