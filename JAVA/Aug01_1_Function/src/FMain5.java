import java.util.Random;
import java.util.Scanner;

public class FMain5 {
	// ���³�..�濡�� ������ �ϰ� �ִµ�.. => ������ �ɺθ� ���ѿ�...
	public static void makeErrand() {
		System.out.println("�Ƶ�~");
		System.out.println("�� ���״ϱ�");
		System.out.println("���۰���");
		System.out.println("����̶�");
		System.out.println("��ġ ���");
		System.out.println("���� �� ������~");
	}
	//�ɺθ� �߿�... (��� : 3200, ��ġ : 2170, ���� : 1500)
	//���� �� ������... ����... ������ �ֽ� ������ �� ���� ���� �� �ܵ��� �����ִ� �Լ� ����
	
	public static int Exchange(int money) {
	Random r = new Random();
	return money - (3200 + 2170 + (r.nextInt(6) + 1) * 1000);
	}
	
	//������ ���� �̴ּ�.(�� = �Է�)
	public static int getMoney() {
		System.out.println("������ �ֽ� ���� �Է��Ͻÿ� : ");
		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();
		System.out.printf("������ %d���� �̴ּ�.\n", money);
		return money;
	}
	
	//����� �ϰ�, �ܵ��� �������� ����...
	public static String returnMoney(int exchange, int money) {
		//���� �� ���
		System.out.printf("�ƴ� �� ���� ���� %d���̳� �ϳ�!!", money - (exchange + 3200 + 2170));
		
		//�ܵ� ���� ���
		String value = exchange >= 0?
				"�׷��� " + String.valueOf(exchange) + "���� ���Ҵ�!":
					"�Ƴ� " + String.valueOf(Math.abs(exchange))  + "�� ���ڸ��� ū�ϳ���...";
		return value;
	}
	
	public static void main(String[] args) {
		int money = getMoney();
		int exchange = Exchange(money);
		System.out.printf("%s",returnMoney(exchange,money));
		
	}
}

/* �Լ��� ǥ���ϴ� 4���� ���! 
 * ��? ����ұ��?
 * ���� ���ϰ�
 * ���� �߰߿� ���ϰ�
 * ���� ����
 * �����ϱ� ���ؼ�
 * 
 * main�Լ��� �ڵ带 �ִ��� ª�� �����ϱ� ���ؼ�
 * ��ɵ��� ��� �Լ���� �ɷ� ���
 * ����� ������ ȿ�������� ���
 * */




