import java.util.Scanner;

public class YMain3 {
	public static int IntputF1() {
		// f1 : ������ �ϳ� �Է� �޾Ƽ�
		System.out.println("�����ϳ� �Է��� �ּ���");
		int f1 = new Scanner(System.in).nextInt();
		return f1;
	}

	public static int IntputF2() {
		// f2 : ������ �ϳ� �Է� �޾Ƽ�
		System.out.println("�����ϳ� �Է��� �ּ���");
		int f2 = new Scanner(System.in).nextInt();
		return f2;
	}

	public static void outputNum(int f1) {
		if (f1 > 0) {
			System.out.println("��");
		} else if (f1 == 0) {
			System.out.println("0");
		} else {
			System.out.println("��");
		}
	}

	public static String outputNum2(int f2) {
		// 3�� ����� 3�� ���
		// 3�� �ƴϰ� 4�� ����� 4�� ���
		// �� �ƴϸ� ����
		// �� �������ִ� �Ѽ�
		if (f2 % 12 == 0)
			return "3�� 4�� ���";
		else if (f2 % 3 == 0)
			return "3�ǹ��";
		else if (f2 % 4 == 0)
			return "4�ǹ��";
		else
			return "����";
	}

	public static void main(String[] args) {
		outputNum(IntputF1());
		System.out.println(outputNum2(IntputF2()));

	}

}
