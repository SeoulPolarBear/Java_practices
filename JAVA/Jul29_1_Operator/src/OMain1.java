import java.util.Scanner;

public class OMain1 {
	public static void main(String[] args) {
		//����
		//�ڷ��� ������ = ��;
		//=(���Կ�����)
		//A = B
		//���׿� �ִ� ���� ���׿� �־��.
		//������ ���� ���� �� ���
		
		//��Ģ����(Scanner + ���) : ��� ������
		// ���ڴ� 2���� �Է� ���� (x,y)
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�ǿ����� 2���� ���� �Է��Ͻÿ�.");
		System.out.print("x : ");
		double x = scanner.nextDouble();
		System.out.print("y : ");
		double y = scanner.nextDouble();
		
		System.out.printf("+ : %.3f  - : %.3f  * : %.3f  / : %.3f  %% : %.3f\n", x + y, Math.abs(x - y), x * y, x / y, x % y );
		
		//int x, int y�� (double) x / y = double ��? (double) x�� �ϴ� double�� ���ϱ� ����, %�� remainder��� �Ѵ�.
		
		//x = 10; y = 4;
		//print(x), print(y)
		//x = y;
		//print(x), print(y)
		//result : 10 4 4 4
		
		//���� ������ Ȱ��
		//+= , -=, *=, /=, %=
		
		x += 1; //x = x + 1
		x -= 1;
		x *= 3;
		x /= 10;
		x %= 10;
		
		//++,--
		
		y = x++;// x = y �� x += 1
		y = ++x; // x += 1 �� x = y
		System.out.println(x);
		
		
		
	}
}
