import java.util.Scanner;

public class CMain6 {
//1���� 12��
	// ���� ��ĥ���� �ٸ��ϴ�.
	// �� ������ �Է��� �޾Ƽ�
	// 30,31,28 ���� �ֽ��ϴ�.
	// 14�� �Է� : ���� ���Դϴ�.

	public static void main(String[] args) {
		System.out.println("���� �Է��Ͻÿ�. : ");
		int month = new Scanner(System.in).nextInt();
		int day = 0;
		if (month <= 12) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;

			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;

			case 2:
				day = 28;
				break;
			}
			System.out.printf("%d���� %d���� �ֽ��ϴ�.", month,day);
		}else
		System.err.printf("%d���� �����ϴ�.", month);//error �޼���ó�� ���̰� �Ѵ�.
		
	}
}
