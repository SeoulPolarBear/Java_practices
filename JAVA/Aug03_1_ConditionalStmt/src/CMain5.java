import java.util.Scanner;

public class CMain5 {
	//���� : DBA(���� �����ͺ��̽� ������) => ��������, ���/����, ��ɾ�� CRUD, ���� Ȱ��
	//DBP(�����ͺ��̽� ���α׷���) ��ɾ� CRUD, ���� Ȱ��, DBU(�����) ���� Ȱ��
	public static String Career() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ ����? : ");
		String Career = scanner.next();
		return Career;
	}
	
	public static void main(String[] args) {
		switch (Career()) {
		case "DBA":
			System.out.println("��������, ���/����, ");
			break;

		default:
			break;
		}
	}
	
}
