
public class FMain4 {
//���� 2���� ������ �� ���� ������ִ� �Լ�
//���� main class�� �����ϴ� �Լ��� static(�����Ҵ�)�� ������ ������ ������ �߻�
//���� : main�Լ����� ����ϱ� ���ؼ��� �޸𸮿� �Ҵ��� �Ǿ� �ִ� ���·� ���縦 �ؾ� �ϴµ�
//�Լ��� static�� �������� ������ main�� �۵��ϴ� ���߿� �Լ��� ���ᰡ �Ǿ ȣȯ���� ������ �߻��Ѵ�.
//���� main class�� �����ϴ� �Լ����� �ݵ�� �Լ� �տ� static�� �ٿ�����Ѵ�.
	
	//�����ε�(overloading) ******** ��ޱ�� �� ���� ���� �Լ� ���� �ǹ̰� �߿��ϴٰ� �����Ǳ� ������ ���ȴ�.
	//�Լ����� ����, parameter���� �ٸ��� �ϴ� ���

	
	
	//	public static int sum(int a, int b) { ->��, ������ ���� return ���� �޶� �����ε��� �� �ȴ�.
	//		return a + b;
	//	}
	
	

	//ȣ���� �� � ���� �־����Ŀ� ���� �Լ��� �ҷ����� �ϴ� ���
	public static void sum(int a, int b) {
		System.out.println(a + b);
	}
	
	//���� 3���� ������ �� ���� ������ִ� �Լ�
	public static void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	//�Ǽ� 3���� ������ �� ���� ������ִ� �Լ�
	public static void sum(double a, double b, double c) {
		System.out.println(a + b + c);
	}
	
	
//	===========================================================
	
	//���� 1���� ������ -> ��!
	public static void printString(int a) {
		System.out.println("��!");
	}
	//���ڿ� 1���� ������ -> ��! ���
	public static void printString(String b) {
		System.out.println("��!");
	}
	//�Ǽ� 1���� ������ -> ���ƾƾ�! ���
	public static void printString(double c) {
		System.out.println("���ƾƾ�!");
	}
	//�ƹ��͵� ���� ������ -> ... ���
	public static void printString() {
		System.out.println("...");
	}
	//�����ε��� ���� ex)print, println, printf
	
	
	public static void main(String[] args) {
		sum(3,2);
		sum(3,2,3);
		sum(3.0, 1.0, 4.0);
		
		printString("g");
	}
}
