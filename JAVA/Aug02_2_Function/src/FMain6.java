import java.util.Random;

public class FMain6 {
//������ ������ �ϳ� ���ϴ� �Լ�
	public static int getNumber() {
		return new Random().nextInt();
	}
//�� ������ ���� ���� ����ϴ� �Լ�
	
	public static int sumNumber(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		//������ ������ 2�� ���ؼ�...
		int a = getNumber();int b = getNumber();
		//�� 2���� ���� ���� ���� ���
		System.out.print("��� : ");
		System.out.println(sumNumber(a,b));
	}
}
