import java.util.Scanner;

//� ���ڸ� �ܼ�â�� �Է�
// �� ������ ����� �����ִ� ���α׷�
//Main���� ���� -> ���� ���� ����
// ex) 12�� ����� : 1, 2, 3, 4, 6, 12
//��� �Է��ϸ� ����� ��� ����ؼ� �����ְ� -> �ܼ�â�� 0�� �Է��ϸ� ���α׷��� ����ǰ�!(0 �Է��ϱ� �������� ���ѹݺ�)
//�迭 ��� x
public class PMain1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = 1;
		while (num != 0) {
			System.out.println("���� �ƴ� ���ڸ� �Է��� �ּ���. :");
			num = scanner.nextInt();
			int i = 0;
			if (num >= 0) {
				System.out.printf("%d�� �����", num);
				for (i = 1; i <= Math.sqrt(num); i++) {
					if (num % i == 0) {
						System.out.print(i);
						System.out.print(" ");
					}
				}
				for (int j = i; j <= num; j++) {
					if (num % j == 0) {
						System.out.print(j);
						System.out.print(" ");
					}
				}
				System.out.println();
			} else
				System.out.println("���� ���� �Դϴ�. �ٽ� �Է��� �ּ���.");
		}
		System.out.println("���α׷��� ����˴ϴ�.");
	}
}
