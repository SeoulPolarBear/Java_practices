import java.util.Scanner;

// ���� 2���� �Է� �޾Ƽ� (������ �Լ���)
// �� ���� 2���� ������ �� ¦���� ����� return �ƴϸ� ���� ���Է�
public class YMain2 {
	//X ��
	public static int getX() {
		System.out.print("x : ");
		int x = new Scanner(System.in).nextInt();
		return x;
	}
	//Y ��
	public static int getY() {
		System.out.print("y : ");
		int y = new Scanner(System.in).nextInt();
		return y;
	}
	//������ ����ؼ� ����� ������ �Լ�
	public static int sum(int x, int y) {
		int c = x + y;
		return c % 2 == 0 ? c : sum(getX(), getY());
	}

	public static void main(String[] args) {
		System.out.println("���� 2���� �Է��Ͻÿ�. : ");
		System.out.println("���� : " + sum(getX(), getY()));
	}
}
