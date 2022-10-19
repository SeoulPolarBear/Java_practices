package BMIproj;
import java.util.Scanner;

public class Support {
	// BMI 검사 프로그램(함수.ver)
		public static void startBMI() {
			System.out.println("===================================");
			System.out.println("\tBMI 검사를 시작~~합니다!");
			System.out.println("===================================");
		}
		
		public static void programStart() {
			System.out.println("어 그래 어서오고");
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
					System.out.print("프로그램이 종료 됩니다.");
					Thread.sleep(500);
			} else if (answer.equals("N") || answer.equals("n")) {
				System.out.println();
				System.out.println("알겠어. 일단 종료 하기 싫은 거지?? 그래도 다시 물어볼거임");
				System.out.print("프로그램을 종료하고 싶으시면 Y 싫으시면 N을 입력해 주세요.");
				programDown();
			} else {
				System.out.println("똑바로 입력해라");
				System.out.println();
				System.out.print("프로그램을 종료하고 싶으시면 Y 싫으시면 N을 입력해 주세요.");
				programDown();
			}
		}
		
		// 이름, 키(cm), 몸무게(kg) 입력 --------1
		public static void InputProfile(Myprofile profile) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("이름을 입력하세요. : ");
			profile.setName(scanner.next());

			System.out.print("키(cm)를 입력하세요. : ");
			profile.setHeight(scanner.nextDouble());

			System.out.print("몸무게(kg)를 입력하세요. : ");
			profile.setWeight(scanner.nextDouble());
		}
}
