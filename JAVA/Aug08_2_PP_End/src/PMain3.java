
public class PMain3 {
//���� �� �� ������ �� ���� ����ϴ� �Լ�
	public static void printSum(int a, int b) {
		System.out.println(a + b);
	}
//���� �� �� ������ �� ���� ����ϴ� �Լ�
	//�����ε� : ���� �Լ� �̸��� �ٸ��� �� �ʿ� ����.(������ ���ٸ�)
	public static void printSum(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	
	//������ n�� ������ �� ���� ����ϴ� �Լ�(�Ķ���Ͱ� �� ������ ��...)
	// �Լ� �Ƕ���ͷ� ���� ������...
	//		(�ڷ���...������)
	public static void printMul(int ...n) {// ***
		int mul = 1;
		for (int i = 0; i < n.length; i++) {
			mul *= n[i];
		}System.out.println(mul);
	}
	public static void main(String[] args) {
		printMul(1,2,34,4,5,656,23);
	}
}
