import java.util.ArrayList;
import java.util.Random;

public class RMain1 {
	public static ArrayList<Integer> array = new ArrayList<Integer>();
	public static void main(String[] args) {
		// �� ���
		int k = 5;
		int a;

		do {
			a = --k;
			System.out.println("��");
		} while (a != 0);

		// ���� 3�� ����ϰ� ����
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d : ��\n", i);
		}

		for (int i = 0; i < 3; i++) {
			System.out.printf("%d : ��\n", i);
		}

		// 5���� 1���� ������� �������� ���
		for (int i = 5; i > 0; i--) {
			System.out.println(i);
		}

	//�ݺ����� 5�� ���� ���ȿ� 1~10������ ���ڸ� �����ϰ� �̰� ���� ��?
		//�ݺ��� �ӿ��� ������ ����� �� ����!(��ȿ�����̴�.)
		//�ݺ����� �� �� �������� ������ ������!
		//���� �ݺ��� �ۿ��� ���� �ϳ��� ���� ���� ���°� ���� �� ȿ����!
		Random rand = new Random();
		int x3 = 0;
		for(int i = 0; i < 5; i++) {
			x3 = rand.nextInt(10) + 1;
			System.out.println(x3);
		}
		System.out.println("-------------------------------");
		
		for(int i = 0;i<5;i++) {
			array.add(rand.nextInt(10) + 1);
		}
		for(int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		System.out.println("-------------------------------");
		//1 + ... + 10 ���� �� ���
		int x = 0;
		for(int i = 1; i < 11; i++) {
			x += i;
		}
		System.out.println(x);
		
		int y = 1;
		for(int i = 1; i < 8; i++) {
			y *= i;
		}
		System.out.println(y);
		
		System.out.println("-------------------------------");
		//1~50���� ���� �߿� 3�� ����ų�, 5�� ����� ���ڸ� �� ���� ���� ���
		int sum_3_5 = 0;
		for(int i = 0; i < 51; i++) {
			if(i%3 == 0 || i%5 == 0) sum_3_5 += i;
		}
		System.out.println(sum_3_5);
		
		
		
		
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		
	}
}
