import java.util.Scanner;

public class YMain2 {
	public static void main(String[] args) {
		//����, ����, ���� ������ �Է� �޾Ƽ� ���
		//������ ��ձ��� ���
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� : ");
		int Korean = scanner.nextInt();
		
		
		
		System.out.print("���� : ");
		int Mathematics = scanner.nextInt();
		
		System.out.print("���� : ");
		int English = scanner.nextInt();
		
		int total = Korean + Mathematics + English;
		
		double avg = total / 3.0;
		
		System.out.printf("���� : %d  ���� : %d  ���� : %d\n", Korean, Mathematics, English);
		System.out.printf("���� : %d  ��� : %.3f", total, avg);
		
	}
}
