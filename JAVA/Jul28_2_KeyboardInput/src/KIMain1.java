import java.util.Scanner;

public class KIMain1 {

	public static void main(String[] args) throws InterruptedException {
		//Scanner : Java�� ����Ǿ� �ִ� ��� �� �ϳ�!
		//�� ����� ����ϱ� ���ؼ� Import��� ���� ����
		//�� Scanner��� �� ����Ϸ��� ������ �ϳ� �ʿ��ѵ�...
		
		//new ~~~ : ��ü
		
		//Scanner�� ȭ��(��Ŭ������ �ܼ�â)���κ��� �����͸� �Է� �޴� ���
		
		Scanner keyboard = new Scanner(System.in);
		
		//Ű, ������, �Ź߻�����, ���డ�� ���� ��, �����ϴ� ����, ��� ������ ����
		System.out.print("�̸� : ");
		String name = keyboard.next();
		System.out.print("Ű : ");
		double height = keyboard.nextDouble();
		System.out.print("������ : ");
		int weight = keyboard.nextInt();
		System.out.print("�߻����� : ");
		int footSize = keyboard.nextInt();
		System.out.print("���డ�� ���� �� : ");
		String visit = keyboard.next();
		System.out.print("�����ϴ� ���� : ");
		int likeNumber = keyboard.nextInt();
		System.out.print("��� ���� ���� : ");
		boolean play = keyboard.nextBoolean();
		
		
		System.out.println("�̸� : " + name);
		System.out.println("Ű : " + height);
		System.out.println("������ : " + weight);
		System.out.println("�Ź߻����� : " + footSize);
		System.out.println("���డ�� ���� �� : " + visit);
		System.out.println("�����ϴ� ���� : " + likeNumber);
		System.out.println("��� ������ ���� : " + play);
		
		
		
	
		
		//bat���� ����
		//���� ������ �ƹ��ų� �����ʽÿ�.
		//���� �Է��ؼ� ���� ġ��
		//1�� ���� .�� 3�� ������ ���α׷� �����մϴ� ��� �޽����� ��µǰ� 0.5���� ���α׷� ����

		System.out.println("���� ������ �ƹ��ų� �����ʽÿ�.");
		String key = keyboard.next();
		keyboard.close();
		
		Thread.sleep(1000);//������ ������ �����ϱ⺸�ٴ� delay�� ��Ű�� �Ŷ�� �����ϸ� �ȴ�.
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print("���α׷� �����մϴ�.");
		Thread.sleep(500);
		
	}

}
