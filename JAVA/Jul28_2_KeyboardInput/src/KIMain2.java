import java.util.Scanner;

public class KIMain2 {
	public static void main(String[] args) {
		//�������� �Է¹޾Ƽ� ���� ���� ����ϱ�
		Scanner scanner = new Scanner(System.in);
//		System.out.println("�������� �Է¹޾Ƽ� ���� ���� ����ϱ�");
//		System.out.print("���� ������ : ");
//		double radian = scanner.nextDouble();
//		
//		double area = Math.PI * Math.pow(radian, 2);
//		
//		System.out.printf("%.3f\n", area);
//		
//		
//		
//	//����,���� �Է� �޾Ƽ� �簢�� ���� ���ϱ�
//		System.out.println("����,���� �Է� �޾Ƽ� �簢�� ���� ���ϱ�");
//		System.out.print("���� : ");
//		double width = scanner.nextDouble();
//		System.out.print("���� : ");
//		double height = scanner.nextDouble();
//		
//		double area2 = width * height;
//		
//		System.out.printf("%.3f", area2);
		
		//�ð�(��)�� �Է� �޾Ƽ� ��, �ð� ������ ��ȯ�ؼ� ���
		System.out.println("�ð�(��)�� �Է� �޾Ƽ� ��, �ð� ������ ��ȯ�ؼ� ���");
		System.out.print("�� : ");
		double second = scanner.nextDouble();
		
		double minute = second / 60;
		double hour = minute / 60;
		
		System.out.printf("�� : %f  �� : %f", minute,hour);
		
		
		//���� int/int = int�� ���´�.
		//���� �ϳ��� double�̸� ����� double�� ���´�.
	}
}
