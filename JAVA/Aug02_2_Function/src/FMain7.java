import java.util.Scanner;
//����� ȣ��(recursive call)
//�Լ� �ӿ��� �ڱ� �ڽ�(�� �Լ�)�� �� ȣ�� -> �ݺ�

//�Լ��� �θ��� : ���� �۾� 
//�ݺ��� :
public class FMain7 {
//�������� 
	// ������ �ϳ� ������
	// 1 + 2 + .. + �� ���ڱ���
	// �� ���� ���� �����ִ� �Լ��� ���ض�
	//
	public static int sum(int a) { return a == 1 ? a : a + sum(a - 1); }

	// ������ �ϳ� ������ factorial ���� ���ϴ� �Լ�
	public static int factorial(int b) { return b == 1 ? b : factorial(b - 1) * b;}

	// �Ǻ���ġ ����
	public static int fibonacci(int c) { return c == 1 || c == 2 ? 1 : fibonacci(c - 1) + fibonacci(c - 2); }

	public static void main(String[] args) throws Exception{
		
		
			System.out.print("���ڸ� �Է��Ͻÿ�. : ");
			System.out.println(sum(new Scanner(System.in).nextInt()));
			System.out.print("���ڸ� �Է��Ͻÿ�. : ");
			System.out.println(factorial(new Scanner(System.in).nextInt()));
			System.out.print("���ڸ� �Է��Ͻÿ�. : ");
			System.out.println(fibonacci(new Scanner(System.in).nextInt()));
	}
}
