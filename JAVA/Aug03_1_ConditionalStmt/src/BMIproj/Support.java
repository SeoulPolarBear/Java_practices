package BMIproj;
import java.util.Scanner;

public class Support {
	// BMI �˻� ���α׷�(�Լ�.ver)
		public static void startBMI() {
			System.out.println("===================================");
			System.out.println("\tBMI �˻縦 ����~~�մϴ�!");
			System.out.println("===================================");
		}
		
		public static void programStart() {
			System.out.println("�� �׷� �����");
		}
		
		public static void programDown() throws InterruptedException {
			Scanner scanner = new Scanner(System.in);
			String answer = scanner.next();
			if (answer.equals("Y") || answer.equals("y")) {
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print("���α׷��� ���� �˴ϴ�.");
					Thread.sleep(500);
			} else if (answer.equals("N") || answer.equals("n")) {
				System.out.println();
				System.out.println("�˰ھ�. �ϴ� ���� �ϱ� ���� ����?? �׷��� �ٽ� �������");
				System.out.print("���α׷��� �����ϰ� �����ø� Y �����ø� N�� �Է��� �ּ���.");
				programDown();
			} else {
				System.out.println("�ȹٷ� �Է��ض�");
				System.out.println();
				System.out.print("���α׷��� �����ϰ� �����ø� Y �����ø� N�� �Է��� �ּ���.");
				programDown();
			}
		}
		
		// �̸�, Ű(cm), ������(kg) �Է� --------1
		public static void InputProfile(Myprofile profile) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("�̸��� �Է��ϼ���. : ");
			profile.setName(scanner.next());

			System.out.print("Ű(cm)�� �Է��ϼ���. : ");
			profile.setHeight(scanner.nextDouble());

			System.out.print("������(kg)�� �Է��ϼ���. : ");
			profile.setWeight(scanner.nextDouble());
		}
}
