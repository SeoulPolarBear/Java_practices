import java.util.Scanner;

//���� �������� ������ִ� ���α׷�

public class YMain2 {
	// �ð��� �Է� �޾Ƽ� -> �ش�ð��� ���ϴ� ������ ���
	// (�Է��� �ð���) �ð� ������ �ƴϸ� �ٽ� �Է�
	public static int InputHour() {
		System.out.print("24�ð� �������� �ð��� �Է����ּ���. : ");
		int hour = new Scanner(System.in).nextInt();
		if (24 > hour && hour >= 0) {
			return hour;
		} else {
			System.out.println("�� �ٽ� �Է���");
			return InputHour();
		}
	}

	public static void Result(int hour) {
		// ���� 9�� ~ ���� 6�� : �п����� ����
		if (9 <= hour && hour < 18)
			System.out.println("�п����� ����");
		// ���� 6�� �Ѿ ~���� 8�� : ���� ���� �ð�
		if (18 <= hour && hour < 20)
			System.out.println("���� ���� �ð�");
		// ���� 9�� , ���� 2�� , ���� 6�� QR ���
		if (9 == hour || hour == 18 || hour == 14)
			System.out.println("QR ���");
		// ���� 12�� : ���ɽð�
		if (12 == hour)
			System.out.println("���ɽð�");

		// ���� 6�� ~ ���� 9�� ������ : ��� + �ı� + �п� ����
		if (6 <= hour && hour < 9)
			System.out.println("��� + �ı� + �п� ����........");
		// ���� 8�� ~ ���� 6�� : �����ð� ��ħ
		if ((20 <= hour && hour <= 23) || (0 <= hour && hour < 6))
			System.out.println("�����ð� ��ħ");
	}

	public static void main(String[] args) {

		Result(InputHour());
	}

}
