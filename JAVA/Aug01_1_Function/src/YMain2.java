import java.util.Random;
import java.util.Scanner;

public class YMain2 {
	public static void main(String[] args) {
		Random r = new Random();
//		int i = r.nextInt();// -2^31~2^31 - 1(int)
//		int i2 = r.nextInt(5);// 0~4
//		int i3 = r.nextInt(5) + 1;// 1~5
//		System.out.println(i);
//		System.out.println(i2);

		// Ȧ¦ ����
		// ���� 10�� ������ ��� �ִٰ�
		// ���� Ȧ�̶�� �ϸ�
		// Ȧ���� ¦���� �����ؼ� �������� �ƴ��� �����ؼ� ����� ����ϴ� ���α׷�
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("\"Ȧ��\" ���� \"¦��\"���� �Է��Ͻÿ�. : ");
		String predict = scanner.next();
		int coin = r.nextInt(11);
		
		String answer = (coin%2 == 0)?"¦��":"Ȧ��";
		System.out.printf("%d������ %s",coin,predict.equals(answer)?"����!":"��");
	}
}
