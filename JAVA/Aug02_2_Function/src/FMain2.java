import java.util.Random;

public class FMain2 {
	//������ ������ "���"�ϴ� �Լ�!
	public static void printInteger() {
		Random rand = new Random();
		int random = rand.nextInt();
		System.out.println(random);
	}
	
	//������ ������ "����"�ϴ� �Լ� => ���� "����"�� �����̴�.
	
	public static int returnInteger() {
		Random rand = new Random();
		int random = rand.nextInt();
		return random;//random�� �ִ� ���� ���� ����� ����
						//�� �Լ��� ����
	}
	
	//������ �ϳ� ������ Ȧ������ ¦������ ����ϴ� �Լ�
	public static void printOdd(int a) {
		System.out.println(a % 2 == 0 ? "¦" : "Ȧ");
	}
	
	//���� 2�� �־��� �� �� ���ڰ� ũ�� "��", �� ���ڰ� ũ�ų� ������ "��" ���ڿ��� �����ϴ� �Լ�!
	public static String returnMaximum(int a, int b) {
		return a>b?"��":"��";
	}
	
	//���ɸ޴� (2���� �� �ϳ�)
	//���� �Լ��� �̿��ؼ� ������ ���� 2���� �̾Ƽ� ���� ������ ũ�� ���� �԰� ������ �ƴϸ� �� �԰� ���� �� ���
	public static void Lunch(int a, int b) {
		System.out.println(a > b ?"�Ұ��":"�������");
	}
	
	//blue()�� ���ؼ� ������ ���ڸ� i��� �׸��� 
	//JVM -> main �Լ��� �ڵ����� ȣ��
	public static void main(String[] args) {
		int randnum = returnInteger();
		printInteger();
		printOdd(randnum);
		System.out.println(returnMaximum(100, 230));
		String sss = returnMaximum(returnInteger(),returnInteger());
		String menu = sss.equals("��") ? "�Ұ��":"�������";
		System.out.println(menu);
	}
}
