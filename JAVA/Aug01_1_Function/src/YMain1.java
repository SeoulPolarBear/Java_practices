import java.util.Scanner;

public class YMain1 {

	public static void main(String[] args) throws InterruptedException {
		//키, 몸무게 입력을 받아서 -> 비만도 검사 프로그램 
		//표준 체중 = (키 - 100) * 0.9
		//비만도 = (실제 체중 / 표준체중) * 100
		//비만도 120이 넘으면 비만, 아니면 비만 아님 문구를 출력
		//아무키나 입력했을 때 프로그램이 종료되게!
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("자신의 키와 몸무게를 입력하시오. : ");
		
		double height = scanner.nextDouble();
		double weight = scanner.nextDouble();
		
		double standard_weight = (height - 100) * 0.9;
		double weight_percent = (weight/standard_weight) * 100;
		
		String obesity = (weight_percent > 120)?"비만": "No 비만";
		
		System.out.printf("당신은 %s 입니다.\n", obesity);
		
		System.out.println("프로그램을 종료하고 싶으시면 아무키를 입력해 주세요");
		
		String key = scanner.next();
		scanner.close();
		
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println("프로그램이 종료됩니다.");
		Thread.sleep(500);
		

	}

}
