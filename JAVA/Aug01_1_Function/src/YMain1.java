import java.util.Scanner;

public class YMain1 {

	public static void main(String[] args) throws InterruptedException {
		//Ű, ������ �Է��� �޾Ƽ� -> �񸸵� �˻� ���α׷� 
		//ǥ�� ü�� = (Ű - 100) * 0.9
		//�񸸵� = (���� ü�� / ǥ��ü��) * 100
		//�񸸵� 120�� ������ ��, �ƴϸ� �� �ƴ� ������ ���
		//�ƹ�Ű�� �Է����� �� ���α׷��� ����ǰ�!
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ڽ��� Ű�� �����Ը� �Է��Ͻÿ�. : ");
		
		double height = scanner.nextDouble();
		double weight = scanner.nextDouble();
		
		double standard_weight = (height - 100) * 0.9;
		double weight_percent = (weight/standard_weight) * 100;
		
		String obesity = (weight_percent > 120)?"��": "No ��";
		
		System.out.printf("����� %s �Դϴ�.\n", obesity);
		
		System.out.println("���α׷��� �����ϰ� �����ø� �ƹ�Ű�� �Է��� �ּ���");
		
		String key = scanner.next();
		scanner.close();
		
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println("���α׷��� ����˴ϴ�.");
		Thread.sleep(500);
		

	}

}
